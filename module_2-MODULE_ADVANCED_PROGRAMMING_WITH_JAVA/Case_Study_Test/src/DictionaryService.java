import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner; 
import java.util.TreeMap;

public class DictionaryService {
    
    // Biến static để giữ thể hiện duy nhất
    private static DictionaryService instance;
    
    // Biến hằng số cho thư mục lưu data
    private static final String DATA_DIR = "dictionary_data";

    // Database: TreeMap
    private Map<String, WordEntity> database;

    private EntityFactory factory;

    // Constructor: PRIVATE
    private DictionaryService() {
        this.database = new TreeMap<>();
        this.factory = new EntityFactory();
        
        // Tải dữ liệu từ file khi khởi động
        loadDataFromFiles();
    }

    public static DictionaryService getInstance() {
        if (instance == null) {
            instance = new DictionaryService();
        }
        return instance;
    }

    // --- Các phương thức ĐỌC/GHI file ---
    
    private void loadDataFromFiles() {
        File dataDir = new File(DATA_DIR);
        
        // Nếu thư mục không tồn tại, tạo nó
        if (!dataDir.exists()) {
            System.out.println("Data directory not found, creating new one...");
            dataDir.mkdirs();
            return;
        }
        
        File[] files = dataDir.listFiles();
        if (files == null) return; 
        
        System.out.println("Loading database from " + files.length + " file(s)...");
        for (File file : files) {
            // Chỉ đọc các file .def
            if (file.isFile() && file.getName().endsWith(".def")) {
                try {
                    WordEntity word = parseWordFile(file);
                    if (word != null) {
                        database.put(word.getKeyword(), word);
                    }
                } catch (Exception e) {
                    System.err.println("Error loading file " + file.getName() + ": " + e.getMessage());
                }
            }
        }
        System.out.println("Load complete!");
    }

    /**
     * Đọc 1 file .def và WordEntity
     */
    private WordEntity parseWordFile(File file) throws Exception {
        try (Scanner fileScanner = new Scanner(file)) {
            if (!fileScanner.hasNextLine()) return null;
            
            // @keyword
            String keyword = fileScanner.nextLine().substring(1); // Bỏ dấu @
            WordEntity word = factory.createWordEntity(keyword);
            
            Definition currentDefinition = null; 
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                if (line.startsWith("=")) { // Ví dụ
                    if (currentDefinition != null) {
                        String sentence = line.substring(1); // Bỏ dấu =
                        String meaning = ""; // Nghĩa mặc định
                        
                        // Đọc dòng tiếp theo 
                        if (fileScanner.hasNextLine()) {
                            String nextLine = fileScanner.nextLine();
                            if (nextLine.startsWith("+")) {
                                meaning = nextLine.substring(1); // Bỏ dấu +
                            }
                        }
                        // Thêm ví dụ 
                        currentDefinition.addExample(factory.createExampleSentence(sentence, meaning));
                    }
                } else if (line.contains(":")) { // Dòng định nghĩa (ví dụ: ADJECTIVE:tích cực)
                    String[] parts = line.split(":", 2);
                    DefinitionType type = DefinitionType.valueOf(parts[0]); // Chuyển "ADJECTIVE" thành Enum
                    String meaning = parts[1];
                    
                    // Tạo định nghĩa mới và thêm vào từ
                    currentDefinition = factory.createDefinition(type, meaning);
                    word.addDefinition(currentDefinition);
                }
            }
            return word;
        }
    }

    /**
     * Lưu 1 đối tượng vào file .def
     */
    public void saveWordToFile(WordEntity word) {
        // Tên file là "keyword.def"
        String fileName = DATA_DIR + File.separator + word.getKeyword() + ".def";
        
        // Dùng try-with-resources để tự động đóng file
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            
            writer.println("@" + word.getKeyword());
            
            for (Definition def : word.getDefinitions()) {
                writer.println(def.getType().name() + ":" + def.getMeaning());
                
                for (ExampleSentence ex : def.getExamples()) {
                    writer.println("=" + ex.getSentence());
                    writer.println("+" + ex.getMeaning());
                }
            }
        } catch (Exception e) {
            System.err.println("Error saving file " + fileName + ": " + e.getMessage());
        }
    }

    // --- Các chức năng chính ---

    /**
     * Chức năng tra từ (lookup)
     */
    public WordEntity lookup(String keyword) {
        return database.get(keyword);
    }

    /**
     * Chức năng xóa từ (drop)
     */
    public boolean drop(String keyword) {
        WordEntity removedWord = database.remove(keyword);
        
        if (removedWord != null) {
            // Xóa khỏi Ổ CỨNG
            try {
                String fileName = DATA_DIR + File.separator + keyword + ".def";
                File file = new File(fileName);
                if (file.exists()) {
                    file.delete();
                }
                return true;
            } catch (Exception e) {
                System.err.println("Error deleting file for " + keyword + ": " + e.getMessage());
                // Xóa file lỗi
                return false; 
            }
        }
        
        return false;
    }

    /**
     * Chức năng thêm định nghĩa (define)
     */
    public WordEntity defineWord(String keyword, DefinitionType type, String meaning) {
        WordEntity word = database.get(keyword);

        if (word == null) {
            word = factory.createWordEntity(keyword);
            database.put(keyword, word);
            System.out.println("DEBUG: @"+ keyword +" is not existed, created new one!");
        }

        Definition newDefinition = factory.createDefinition(type, meaning);

        word.addDefinition(newDefinition);
        
        saveWordToFile(word);
        
        return word;
    }

    /**
     * Chức năng xuất file (export)
     */
    public void exportToFile(String filePath) throws Exception {
        System.out.println("Exporting...");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath))) {
            
            int totalWords = database.size();
            int count = 0;

            for (WordEntity word : database.values()) {
                // Định dạng dữ liệu xuất ra file
                writer.println("@" + word.getKeyword());
                
                for (Definition def : word.getDefinitions()) {
                    writer.println("- " + def.getType() + ": " + def.getMeaning());
                    
                    for (ExampleSentence ex : def.getExamples()) {
                        writer.println("  = " + ex.getSentence());
                        writer.println("  + " + ex.getMeaning());
                    }
                }
                writer.println("---"); // Ngăn cách giữa các từ
                
                // Cập nhật tiến trình
                count++;
                int progress = (int) (((double) count / totalWords) * 100);
                System.out.print(progress + "%..");
            }
        }
        System.out.println("Done!");
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer; // Một interface để lưu trữ một "hành động"

public class DictionaryController {
    
    private DictionaryService service; 
    private RequestParser parser;      // "Phiên dịch"
    private Scanner inputScanner;      // Nhận input

    private Map<String, Consumer<Request>> actionMap; 
    
    // Chuyển đổi loại định nghĩa từ chuỗi sang Enum
    private Map<String, DefinitionType> definitionTypeMap;

    public DictionaryController() {
        this.service = DictionaryService.getInstance(); 
        this.parser = new RequestParser();
        this.inputScanner = new Scanner(System.in);
        
        this.actionMap = new HashMap<>();
        initializeActionMap();
        
        // Chuyển đổi loại
        this.definitionTypeMap = new HashMap<>();
        initializeDefinitionTypeMap();
    }

    public void execute(String rawCommand) {
        // Chuỗi lệnh thô
        Request request = parser.parse(rawCommand);
        
        // Tìm hành động tương ứng
        Consumer<Request> action = actionMap.getOrDefault(request.getAction(), this::handleUnknown);
        
        // Thực thi
        action.accept(request);
    }
    
    /**
     * Khởi tạo Map
     */
    private void initializeActionMap() {
        actionMap.put("lookup", this::handleLookup);
        actionMap.put("define", this::handleDefine);
        actionMap.put("drop", this::handleDrop);
        actionMap.put("export", this::handleExport);
    }
    
    /**
     * Khởi tạo Map chuyển đổi
     */
    private void initializeDefinitionTypeMap() {
        definitionTypeMap.put("--pronoun", DefinitionType.PRONOUNCIATION);
        definitionTypeMap.put("-p", DefinitionType.PRONOUNCIATION);
        definitionTypeMap.put("--noun", DefinitionType.NOUN);
        definitionTypeMap.put("-n", DefinitionType.NOUN);
        definitionTypeMap.put("--adjective", DefinitionType.ADJECTIVE);
        definitionTypeMap.put("-a", DefinitionType.ADJECTIVE);
        definitionTypeMap.put("--verb", DefinitionType.VERB);
        definitionTypeMap.put("-v", DefinitionType.VERB);
        definitionTypeMap.put("--synonymous", DefinitionType.SYNONYMOUS);
        definitionTypeMap.put("-s", DefinitionType.SYNONYMOUS);
    }

    // --- Các phương thức hành động---

    private void handleLookup(Request request) {
        WordEntity word = service.lookup(request.getKeyword());
        if (word == null) {
            System.out.println("Từ '" + request.getKeyword() + "' không tồn tại.");
        } else {
            printWord(word); 
        }
    }

    private void handleDrop(Request request) {
        boolean dropped = service.drop(request.getKeyword());
        if (dropped) {
            System.out.println("@" + request.getKeyword() + " dropped!");
        } else {
            System.out.println("Từ '" + request.getKeyword() + "' không tồn tại để xóa.");
        }
    }

    private void handleExport(Request request) {
        if (request.getParams().isEmpty()) {
            System.out.println("Lỗi: Vui lòng nhập đường dẫn file. Ví dụ: export eng-vie.txt");
            return;
        }
        String filePath = request.getParams().get(0);
        try {
            service.exportToFile(filePath);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất file: " + e.getMessage());
        }
    }
    
    private void handleUnknown(Request request) {
        System.out.println("Action '" + request.getAction() + "' không hợp lệ.");
        System.out.println("Các action hỗ trợ: lookup, define, drop, export");
    }
    
    private void handleDefine(Request request) {
        // Kiểm tra tham số
        if (request.getParams().isEmpty() || request.getKeyword() == null) {
            System.out.println("Lỗi cú pháp. Ví dụ: define --adjective positive");
            return;
        }

        String typeString = request.getParams().get(0); 
        String keyword = request.getKeyword();        
        
        // Chuyển đổi chuỗi
        DefinitionType type = definitionTypeMap.get(typeString);
        if (type == null) {
            System.out.println("Loại định nghĩa '" + typeString + "' không hợp lệ.");
            return;
        }

        // Hỏi định nghĩa
        System.out.print(type + " defination: ");
        String meaning = inputScanner.nextLine();
        
        // Gọi service
        WordEntity word = service.defineWord(keyword, type, meaning);

        // Lấy về định nghĩa
        Definition newDef = word.getDefinitions().get(word.getDefinitions().size() - 1);

        // Chỉ hỏi câu mẫu nếu là danh từ, tính từ, động từ
        if (type == DefinitionType.NOUN || type == DefinitionType.ADJECTIVE || type == DefinitionType.VERB) {
            System.out.print("Sentence: ");
            String sentence = inputScanner.nextLine();
            
            if (!sentence.isEmpty()) {
                System.out.print("Sentence's meaning: ");
                String sentenceMeaning = inputScanner.nextLine();
                
                newDef.addExample(new ExampleSentence(sentence, sentenceMeaning));

                service.saveWordToFile(word);
            }
        }
        System.out.println("Saved!");
    }

    /**
     * Phương thức in một mục từ
     */
    private void printWord(WordEntity word) {
        System.out.println("@" + word.getKeyword());
        for (Definition def : word.getDefinitions()) {
            // In loại định nghĩa
            System.out.println("* " + def.getType().toString());
            // In nghĩa
            System.out.println("- " + def.getMeaning());
            
            // In các câu ví dụ
            for (ExampleSentence ex : def.getExamples()) {
                System.out.println("= " + ex.getSentence());
                System.out.println("+ " + ex.getMeaning());
            }
        }
    }
}
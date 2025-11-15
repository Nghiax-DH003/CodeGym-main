// DictionaryController.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer; // Một interface để lưu trữ một "hành động"

public class DictionaryController {
    
    private DictionaryService service; // "Người thủ thư"
    private RequestParser parser;      // "Người phiên dịch"
    private Scanner inputScanner;      // Để nhận input (như nghĩa, câu mẫu)

    // Map để lưu các hành động, thay thế cho if/else
    private Map<String, Consumer<Request>> actionMap; 
    
    // Map để chuyển đổi loại định nghĩa từ chuỗi sang Enum
    private Map<String, DefinitionType> definitionTypeMap;

    public DictionaryController() {
        // Lấy về "người thủ thư" duy nhất
        this.service = DictionaryService.getInstance(); 
        this.parser = new RequestParser();
        this.inputScanner = new Scanner(System.in);
        
        // Khởi tạo các "hành động"
        this.actionMap = new HashMap<>();
        initializeActionMap();
        
        // Khởi tạo map chuyển đổi loại
        this.definitionTypeMap = new HashMap<>();
        initializeDefinitionTypeMap();
    }

    /**
     * Phương thức chính, nhận một yêu cầu và thực thi nó
     * (Đây là phương thức bạn đang bị thiếu)
     */
    public void execute(String rawCommand) {
        // 1. Phân tích chuỗi lệnh thô thành Request
        Request request = parser.parse(rawCommand);
        
        // 2. Tìm hành động tương ứng trong Map
        // Nếu không tìm thấy, dùng một hành động mặc định (handleUnknown)
        Consumer<Request> action = actionMap.getOrDefault(request.getAction(), this::handleUnknown);
        
        // 3. Thực thi hành động
        action.accept(request);
    }
    
    /**
     * Khởi tạo Map chứa các hành động
     */
    private void initializeActionMap() {
        // Dùng lambda (->) để định nghĩa các hành động
        actionMap.put("lookup", this::handleLookup);
        actionMap.put("define", this::handleDefine);
        actionMap.put("drop", this::handleDrop);
        actionMap.put("export", this::handleExport);
    }
    
    /**
     * Khởi tạo Map chuyển đổi loại định nghĩa
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

    // --- Các phương thức xử lý hành động CỤ THỂ ---

    private void handleLookup(Request request) {
        WordEntity word = service.lookup(request.getKeyword());
        if (word == null) {
            System.out.println("Từ '" + request.getKeyword() + "' không tồn tại.");
        } else {
            // Chúng ta cần một hàm in cho đẹp
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
    
    /**
     * Đây là hàm xử lý phức tạp nhất, vì nó cần hỏi thêm người dùng
     */
    private void handleDefine(Request request) {
        // Kiểm tra xem có đủ tham số không
        if (request.getParams().isEmpty() || request.getKeyword() == null) {
            System.out.println("Lỗi cú pháp. Ví dụ: define --adjective positive");
            return;
        }

        String typeString = request.getParams().get(0); // ví dụ: "--adjective"
        String keyword = request.getKeyword();          // ví dụ: "positive"
        
        // Chuyển đổi chuỗi "--adjective" thành Enum DefinitionType.ADJECTIVE
        DefinitionType type = definitionTypeMap.get(typeString);
        if (type == null) {
            System.out.println("Loại định nghĩa '" + typeString + "' không hợp lệ.");
            return;
        }

        // Hỏi người dùng định nghĩa
        System.out.print(type + " defination: ");
        String meaning = inputScanner.nextLine();
        
        // Gọi service để thêm (hoặc tạo mới)
        // Lưu ý: Dòng "created new one" được in từ trong Service
        WordEntity word = service.defineWord(keyword, type, meaning);

        // Lấy về định nghĩa cuối cùng vừa thêm
        Definition newDef = word.getDefinitions().get(word.getDefinitions().size() - 1);

        // Chỉ hỏi câu mẫu nếu là danh từ, tính từ, động từ
        if (type == DefinitionType.NOUN || type == DefinitionType.ADJECTIVE || type == DefinitionType.VERB) {
            System.out.print("Sentence: ");
            String sentence = inputScanner.nextLine();
            
            // Nếu người dùng nhập câu mẫu
            if (!sentence.isEmpty()) {
                System.out.print("Sentence's meaning: ");
                String sentenceMeaning = inputScanner.nextLine();
                
                // Thêm câu mẫu vào định nghĩa
                newDef.addExample(new ExampleSentence(sentence, sentenceMeaning));

                // NÂNG CAO: Vì chúng ta đã thêm ví dụ, 
                // chúng ta cần báo Service lưu lại file một lần nữa
                service.saveWordToFile(word);
            }
        }
        System.out.println("Saved!");
    }

    /**
     * Phương thức trợ giúp để in một mục từ theo định dạng đẹp
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
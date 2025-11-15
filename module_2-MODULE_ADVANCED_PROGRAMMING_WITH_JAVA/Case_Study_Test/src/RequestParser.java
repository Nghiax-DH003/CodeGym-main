// RequestParser.java
public class RequestParser {

    // Phương thức chính của chúng ta
    public Request parse(String rawInput) {
        // Cắt chuỗi đầu vào bằng dấu cách
        String[] parts = rawInput.trim().split(" ");
        
        Request request = new Request();
        
        if (parts.length == 0) {
            // Trường hợp không nhập gì
            return request; // Trả về request rỗng
        }
        
        // Phần tử đầu tiên luôn là 'action'
        String action = parts[0].toLowerCase(); // Chuyển sang chữ thường
        request.setAction(action);
        
        // Bây giờ, chúng ta xử lý dựa trên từng action
        // Đây là cách làm đơn giản dùng switch-case
        // (Sau này ở Controller, chúng ta sẽ làm theo cách nâng cao)
        switch (action) {
            case "lookup": // Ví dụ: lookup positive
            case "drop":   // Ví dụ: drop positive
                if (parts.length > 1) {
                    request.setKeyword(parts[1]);
                }
                break;
                
            case "define": // Ví dụ: define --adjective positive
                if (parts.length > 2) {
                    // param 0 là loại định nghĩa (ví dụ: --adjective)
                    request.addParam(parts[1]); 
                    // keyword là từ (ví dụ: positive)
                    request.setKeyword(parts[2]);
                }
                break;
                
            case "export": // Ví dụ: export ~/dicts/eng-vie.txt
                if (parts.length > 1) {
                    // param 0 là đường dẫn file
                    request.addParam(parts[1]); 
                }
                break;
                
            default:
                // Action không xác định, có thể gán là 'unknown'
                request.setAction("unknown");
                break;
        }
        
        return request;
    }
}
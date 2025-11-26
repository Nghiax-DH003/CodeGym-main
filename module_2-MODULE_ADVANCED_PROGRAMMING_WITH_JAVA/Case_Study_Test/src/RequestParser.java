public class RequestParser {


    public Request parse(String rawInput) {

        String[] parts = rawInput.trim().split(" ");
        
        Request request = new Request();
        
        if (parts.length == 0) {
            // Trường hợp không nhập gì
            return request;
        }
        
        String action = parts[0].toLowerCase(); // Chuyển sang chữ thường
        request.setAction(action);
        
 
        switch (action) {
            case "lookup":
            case "drop":  
                if (parts.length > 1) {
                    request.setKeyword(parts[1]);
                }
                break;
                
            case "define":
                if (parts.length > 2) {
                    request.addParam(parts[1]); 
                    request.setKeyword(parts[2]);
                }
                break;
                
            case "export":
                if (parts.length > 1) {
                    request.addParam(parts[1]); 
                }
                break;
                
            default:
                request.setAction("unknown");
                break;
        }
        
        return request;
    }
}
// Main.java
import java.util.Scanner; // Cần để đọc input từ người dùng

public class Main {

    public static void main(String[] args) {
        
        // 1. Khởi tạo "người giao dịch" (Controller)
        // Controller sẽ tự động tìm và "thuê" "người thủ thư" (Service)
        DictionaryController controller = new DictionaryController();

        // 2. Tạo một Scanner để đọc lệnh từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // 3. In ra lời nhắc cho người dùng
        System.out.print("Action: ");

        // 4. Đọc MỘT dòng lệnh duy nhất mà người dùng nhập
        String command = scanner.nextLine();

        // 5. Giao dòng lệnh đó cho Controller xử lý
        // Controller sẽ tự động phân tích (parse), gọi Service, và in kết quả
        controller.execute(command);

        // 6. Đóng Scanner lại
        scanner.close();
        
        // Chương trình sẽ tự động kết thúc sau khi hàm main chạy xong
        // Điều này đúng với yêu cầu: "thực hiện tính năng tương ứng sau đó đóng"
    }
}
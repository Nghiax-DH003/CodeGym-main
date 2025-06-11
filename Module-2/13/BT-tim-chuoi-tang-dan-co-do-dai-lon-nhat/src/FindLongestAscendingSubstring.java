import java.util.LinkedList;
import java.util.Scanner;

public class FindLongestAscendingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Đối tượng để đọc đầu vào từ người dùng

        System.out.print("Enter a string: "); // Yêu cầu người dùng nhập chuỗi
        String inputString = scanner.nextLine(); // Đọc chuỗi người dùng nhập

        // LinkedList để lưu trữ chuỗi con tăng dần hiện tại
        LinkedList<Character> currentLongestAscendingSubstring = new LinkedList<>();
        // LinkedList để lưu trữ chuỗi con tăng dần dài nhất đã tìm thấy
        LinkedList<Character> maxLongestAscendingSubstring = new LinkedList<>();

        // Duyệt qua từng ký tự của chuỗi nhập vào
        for (int i = 0; i < inputString.length(); i++) {
            // Nếu chuỗi con hiện tại không rỗng VÀ ký tự hiện tại nhỏ hơn HOẶC BẰNG ký tự cuối cùng của chuỗi con hiện tại
            // Tức là chuỗi con hiện tại không còn tăng dần nữa
            if (!currentLongestAscendingSubstring.isEmpty() &&
                    inputString.charAt(i) <= currentLongestAscendingSubstring.getLast()) {
                // Xóa tất cả các phần tử của chuỗi con hiện tại
                currentLongestAscendingSubstring.clear();
            }

            // Thêm ký tự hiện tại vào chuỗi con tăng dần hiện tại
            currentLongestAscendingSubstring.add(inputString.charAt(i));

            // Nếu độ dài của chuỗi con hiện tại lớn hơn chuỗi con dài nhất đã tìm thấy
            if (currentLongestAscendingSubstring.size() > maxLongestAscendingSubstring.size()) {
                // Cập nhật chuỗi con dài nhất bằng cách sao chép từ chuỗi con hiện tại
                // Tạo một LinkedList mới từ currentLongestAscendingSubstring
                maxLongestAscendingSubstring = new LinkedList<>(currentLongestAscendingSubstring);
            }
        }

        // In ra chuỗi con tăng dần dài nhất
        // Duyệt qua LinkedList và in từng ký tự
        for (Character ch : maxLongestAscendingSubstring) {
            System.out.print(ch);
        }
        System.out.println(); // Xuống dòng
        scanner.close(); // Đóng đối tượng Scanner
    }
}
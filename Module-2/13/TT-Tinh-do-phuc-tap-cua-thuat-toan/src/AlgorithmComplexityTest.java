import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            int ascii = (int) inputString.charAt(i);
            frequentChar[ascii] += 1;
        }

        // {5} Khởi tạo biến 'max' để lưu trữ tần suất cao nhất tìm thấy
        int max = 0;
        // {6} Khởi tạo biến 'character' để lưu trữ ký tự có tần suất cao nhất.
        // Khởi tạo bằng ký tự rỗng hoặc một giá trị mặc định.
        char character = (char) 0; // Sử dụng 0 để đại diện cho ký tự null hoặc không xác định

        // {7} Vòng lặp duyệt qua mảng tần suất (255 phần tử)
        for (int j = 0; j < 255; j++) {
            // {8} So sánh tần suất của ký tự hiện tại với 'max'
            if (frequentChar[j] > max) {
                // {9} Cập nhật 'max' nếu tìm thấy tần suất lớn hơn
                max = frequentChar[j];
                // {10} Cập nhật 'character' thành ký tự tương ứng với tần suất lớn nhất
                character = (char) j;
            }
        }

        // In kết quả
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");

        scanner.close();
    }
}
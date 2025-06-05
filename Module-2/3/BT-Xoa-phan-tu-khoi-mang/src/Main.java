import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        int n = 5;

        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xóa (X): ");
        int x = scanner.nextInt();

        int index_del = -1;

        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                index_del = i;
                System.out.println("Tìm thấy phần tử " + x + " tại vị trí " + index_del);
                break;
            }
        }

        System.out.println("\n--- Thực hiện xóa ---");
        if (index_del == -1) {
            System.out.println("Phần tử " + x + " không có trong mảng. Mảng không thay đổi.");
        } else {
            for (int i = index_del; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            System.out.println("Phần tử " + x + " đã được xóa.");
        }

        System.out.println("Mảng sau khi xóa (hoặc không thay đổi):");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Số lượng phần tử hợp lệ trong mảng hiện tại: " + n);

        scanner.close();
    }
}
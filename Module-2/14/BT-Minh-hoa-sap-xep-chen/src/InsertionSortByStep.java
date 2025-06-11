import java.util.Arrays;

public class InsertionSortByStep {

    public static void main(String[] args) {
        int[] list = {10, 3, 7, 1, 9, 2, 8, 5};
        System.out.println("Mảng ban đầu: " + Arrays.toString(list));
        System.out.println("----------------------------------------");

        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int currentElement = array[i];
            int k = i - 1;

            System.out.println("\nBước " + i + ": Đang xem xét chèn phần tử " + currentElement + " vào đoạn đã sắp xếp.");

            while (k >= 0 && currentElement < array[k]) {
                array[k + 1] = array[k];
                k--;
                System.out.println("   - Dịch chuyển " + array[k+1] + " sang phải. Mảng hiện tại: " + Arrays.toString(array));
            }

            array[k + 1] = currentElement;
            System.out.println("   - Chèn " + currentElement + " vào vị trí " + (k + 1) + ". Mảng sau bước " + i + ": " + Arrays.toString(array));
            System.out.println("----------------------------------------");
        }
        System.out.println("\nQuá trình sắp xếp hoàn tất!");
        System.out.println("Mảng cuối cùng: " + Arrays.toString(array));
    }
}

public class BinarySearch {
    // Bước 1: Khai báo mảng số nguyên được sắp xếp theo thứ tự tăng dần.
    // Đảm bảo rằng 'list' được khai báo là static để có thể truy cập trực tiếp từ phương thức main
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    // Bước 2: Cài đặt phương thức binarySearch(int[] list, int key).
    static int binarySearch(int[] arr, int key) { // Đổi tên tham số từ 'list' sang 'arr' để tránh nhầm lẫn với biến toàn cục 'list'
        int low = 0;
        int high = arr.length - 1; // Sử dụng 'arr.length' thay vì 'list.length'

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) // Sử dụng 'arr[mid]'
                high = mid - 1;
            else if (key == arr[mid]) // Sử dụng 'arr[mid]'
                return mid;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Bước 3: Cài đặt phương thức main để thực thi ứng dụng.
    public static void main(String[] args) {
        System.out.println("Kết quả tìm kiếm:");
        // Khi gọi phương thức binarySearch, chúng ta truyền mảng 'list' đã được khai báo ở trên vào.
        System.out.println("Tìm 2: " + binarySearch(list, 2));   /* 0 */
        System.out.println("Tìm 11: " + binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }
}
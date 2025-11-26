import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager quanLy = new ContactManager();

        while (true) {
            System.out.println("\n--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");

            String chon = scanner.nextLine();

            switch (chon) {
                case "1": quanLy.hienThiDanhSach(); break;
                case "2": quanLy.themMoi(); break;
                case "3": quanLy.capNhat(); break;
                case "4": quanLy.xoa(); break;
                case "5": quanLy.timKiem(); break;
                case "6": quanLy.docFile(); break;
                case "7": quanLy.ghiFile(); break;
                case "8": System.exit(0);
                default: System.out.println("Chọn sai, vui lòng chọn lại!");
            }
        }
    }
}
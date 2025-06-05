import java.util.Scanner;

public class DrawingShapes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 4) {
            System.out.println("----- Menu Hiển thị Hình -----");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In hình tam giác vuông");
            System.out.println("3. In hình tam giác cân");
            System.out.println("4. Thoát chương trình");
            System.out.print("Vui lòng chọn một tùy chọn (1-4): ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Bạn đã chọn: In hình chữ nhật");
                    System.out.print("Nhập chiều dài (số hàng): ");
                    int length = input.nextInt();
                    System.out.print("Nhập chiều rộng (số cột): ");
                    int width = input.nextInt();

                    System.out.println("\n--- Hình chữ nhật ---");
                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Bạn đã chọn: In hình tam giác vuông");
                    System.out.print("Nhập chiều cao của tam giác: ");
                    int height = input.nextInt();

                    System.out.println("Chọn góc vuông:");
                    System.out.println("  1. Dưới cùng bên trái");
                    System.out.println("  2. Trên cùng bên trái");
                    System.out.println("  3. Dưới cùng bên phải");
                    System.out.println("  4. Trên cùng bên phải");
                    System.out.print("Nhập lựa chọn góc (1-4): ");
                    int triangleType = input.nextInt();

                    switch (triangleType) {
                        case 1:
                            System.out.println("\n--- Tam giác vuông bottom-left ---");
                            for (int i = 1; i <= height; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            System.out.println("\n--- Tam giác vuông top-left ---");
                            for (int i = height; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            System.out.println("\n--- Tam giác vuông bottom-right ---");
                            for (int i = 1; i <= height; i++) {
                                for (int j = 1; j <= height - i; j++) {
                                    System.out.print("  ");
                                }
                                for (int k = 1; k <= i; k++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            System.out.println("\n--- Tam giác vuông top-right ---");
                            for (int i = height; i >= 1; i--) {
                                for (int j = 1; j <= height - i; j++) {
                                    System.out.print("  ");
                                }
                                for (int k = 1; k <= i; k++) {
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        default:
                            System.out.println("Lựa chọn góc không hợp lệ.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Bạn đã chọn: In hình tam giác cân");
                    System.out.print("Nhập chiều cao của tam giác cân: ");
                    int isoHeight = input.nextInt();

                    System.out.println("\n--- Tam giác cân ---");
                    for (int i = 1; i <= isoHeight; i++) {
                        for (int j = 1; j <= isoHeight - i; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
            System.out.println("\n");
        }
        input.close();
    }
}

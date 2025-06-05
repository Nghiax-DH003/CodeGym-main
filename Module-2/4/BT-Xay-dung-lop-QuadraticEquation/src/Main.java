import java.util.Scanner;

public class Main { // Hoặc TestQuadraticEquation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Giải Phương trình Bậc Hai: ax^2 + bx + c = 0 ---");

        System.out.print("Nhập giá trị a: ");
        double a = scanner.nextDouble();

        System.out.print("Nhập giá trị b: ");
        double b = scanner.nextDouble();

        System.out.print("Nhập giá trị c: ");
        double c = scanner.nextDouble();

        // Tạo đối tượng QuadraticEquation với các hệ số vừa nhập
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double delta = equation.getDiscriminant(); // Lấy delta từ đối tượng

        System.out.println("\n--- Kết quả ---");
        if (a == 0) {
            // Đây là trường hợp đặc biệt: phương trình bậc nhất
            // (b*x + c = 0)
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình vô số nghiệm.");
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            } else {
                double x = -c / b;
                System.out.println("Đây là phương trình bậc nhất. Nghiệm: x = " + x);
            }
        } else if (delta >= 0) {
            if (delta == 0) {
                double root = equation.getRoot1(); // Hoặc getRoot2(), vì chúng bằng nhau
                System.out.printf("Phương trình có 1 nghiệm kép: x = %.2f\n", root);
            } else { // delta > 0
                double root1 = equation.getRoot1();
                double root2 = equation.getRoot2();
                System.out.printf("Phương trình có 2 nghiệm phân biệt:\n");
                System.out.printf("x1 = %.2f\n", root1);
                System.out.printf("x2 = %.2f\n", root2);
            }
        } else { // delta < 0
            System.out.println("The equation has no roots");
        }

        scanner.close();
    }
}
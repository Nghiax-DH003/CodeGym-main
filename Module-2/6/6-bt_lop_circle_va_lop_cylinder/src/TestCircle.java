// Chương trình kiểm thử cho lớp Circle
public class TestCircle {
    public static void main(String[] args) {
        // --- KIỂM THỬ LỚP CIRCLE ---
        System.out.println("--- KIỂM THỬ LỚP CIRCLE ---");
        System.out.println("Tạo một đối tượng Circle với bán kính 3.0 và màu \"orange\".");
        Circle circle = new Circle(3.0, "orange"); // Tạo một đối tượng Circle để kiểm thử

        System.out.println("Thông tin khởi tạo: " + circle.toString());
        System.out.printf("Bán kính: %.2f%n", circle.getRadius());
        System.out.printf("Màu sắc: %s%n", circle.getColor());
        System.out.printf("Diện tích: %.2f%n", circle.getArea());

        // Kiểm tra setters
        System.out.println("\nCập nhật Circle: Đặt bán kính là 5.0 và màu là \"purple\".");
        circle.setRadius(5.0);
        circle.setColor("purple");
        System.out.println("Thông tin sau khi cập nhật: " + circle.toString());
        System.out.printf("Bán kính mới: %.2f%n", circle.getRadius());
        System.out.printf("Màu sắc mới: %s%n", circle.getColor());
        System.out.printf("Diện tích mới: %.2f%n", circle.getArea());
        System.out.println("--------------------\n");
    }
}
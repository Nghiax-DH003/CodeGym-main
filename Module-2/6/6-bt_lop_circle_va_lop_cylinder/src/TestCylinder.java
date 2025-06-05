public class TestCylinder {
    public static void main(String[] args) {
        // --- KIỂM THỬ LỚP CYLINDER ---
        System.out.println("--- KIỂM THỬ LỚP CYLINDER ---");
        System.out.println("Tạo một đối tượng Cylinder với chiều cao 10.0, bán kính 4.0 và màu \"blue\".");
        Cylinder cylinder = new Cylinder(10.0, 4.0, "blue"); // Tạo một đối tượng Cylinder để kiểm thử

        System.out.println("Thông tin khởi tạo: " + cylinder.toString());
        System.out.printf("Bán kính đáy: %.2f%n", cylinder.getRadius()); // Kế thừa từ Circle
        System.out.printf("Màu sắc: %s%n", cylinder.getColor());     // Kế thừa từ Circle
        System.out.printf("Chiều cao: %.2f%n", cylinder.getHeight());
        System.out.printf("Diện tích đáy: %.2f%n", cylinder.getArea()); // Kế thừa từ Circle
        System.out.printf("Thể tích: %.2f%n", cylinder.getVolume());

        // Kiểm tra setters
        System.out.println("\nCập nhật Cylinder: Đặt chiều cao là 15.0, bán kính là 6.0 và màu là \"green\".");
        cylinder.setHeight(15.0);
        cylinder.setRadius(6.0);    // Setter kế thừa
        cylinder.setColor("green"); // Setter kế thừa
        System.out.println("Thông tin sau khi cập nhật: " + cylinder.toString());
        System.out.printf("Bán kính đáy mới: %.2f%n", cylinder.getRadius());
        System.out.printf("Màu sắc mới: %s%n", cylinder.getColor());
        System.out.printf("Chiều cao mới: %.2f%n", cylinder.getHeight());
        System.out.printf("Diện tích đáy mới: %.2f%n", cylinder.getArea());
        System.out.printf("Thể tích mới: %.2f%n", cylinder.getVolume());
        System.out.println("--------------------");

    }
}
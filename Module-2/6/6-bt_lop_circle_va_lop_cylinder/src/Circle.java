// Định nghĩa lớp Circle (Hình tròn)
public class Circle {
    // Thuộc tính private để đóng gói dữ liệu
    private double radius; // Bán kính hình tròn
    private String color;  // Màu sắc hình tròn

    /**
     * Constructor mặc định.
     * Khởi tạo một đối tượng Circle với bán kính mặc định là 1.0 và màu sắc là "red".
     */
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    /**
     * Constructor với bán kính tùy chỉnh.
     * Khởi tạo một đối tượng Circle với bán kính được chỉ định và màu sắc mặc định là "red".
     * @param radius Bán kính của hình tròn.
     */
    public Circle(double radius) {
        this.radius = radius;
        this.color = "red"; // Giữ màu mặc định nếu chỉ cung cấp bán kính
    }

    /**
     * Constructor với bán kính và màu sắc tùy chỉnh.
     * Khởi tạo một đối tượng Circle với bán kính và màu sắc được chỉ định.
     * @param radius Bán kính của hình tròn.
     * @param color Màu sắc của hình tròn.
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // --- Getters và Setters cho các thuộc tính ---

    /**
     * Trả về bán kính của hình tròn.
     * @return Bán kính hiện tại.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Đặt bán kính mới cho hình tròn.
     * @param radius Bán kính mới.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Trả về màu sắc của hình tròn.
     * @return Màu sắc hiện tại.
     */
    public String getColor() {
        return color;
    }

    /**
     * Đặt màu sắc mới cho hình tròn.
     * @param color Màu sắc mới.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Tính toán và trả về diện tích của hình tròn.
     * Công thức: Diện tích = PI * radius * radius.
     * @return Diện tích của hình tròn.
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Cài đè phương thức toString() để cung cấp mô tả chi tiết về đối tượng Circle.
     * @return Chuỗi mô tả đối tượng Circle.
     */
    @Override
    public String toString() {
        return "A Circle with radius="
                + String.format("%.2f", getRadius()) // Định dạng để hiển thị 2 chữ số thập phân
                + " and color="
                + getColor();
    }
}
// Định nghĩa lớp Cylinder (Hình trụ), kế thừa từ lớp Circle
public class Cylinder extends Circle {
    // Thuộc tính riêng của Cylinder
    private double height; // Chiều cao của hình trụ

    /**
     * Constructor mặc định.
     * Khởi tạo một đối tượng Cylinder với bán kính và màu sắc mặc định từ Circle,
     * và chiều cao mặc định là 1.0.
     */
    public Cylinder() {
        super(); // Gọi constructor mặc định của lớp cha Circle
        this.height = 1.0;
    }

    /**
     * Constructor với chiều cao tùy chỉnh.
     * Khởi tạo một đối tượng Cylinder với chiều cao được chỉ định,
     * và bán kính, màu sắc mặc định từ Circle.
     * @param height Chiều cao của hình trụ.
     */
    public Cylinder(double height) {
        super(); // Gọi constructor mặc định của lớp cha Circle
        this.height = height;
    }

    /**
     * Constructor với chiều cao và bán kính tùy chỉnh.
     * Khởi tạo một đối tượng Cylinder với chiều cao và bán kính được chỉ định,
     * màu sắc mặc định từ Circle.
     * @param height Chiều cao của hình trụ.
     * @param radius Bán kính đáy của hình trụ (từ lớp Circle).
     */
    public Cylinder(double height, double radius) {
        super(radius); // Gọi constructor của lớp cha Circle với bán kính
        this.height = height;
    }

    /**
     * Constructor với chiều cao, bán kính và màu sắc tùy chỉnh.
     * Khởi tạo một đối tượng Cylinder với tất cả các thuộc tính được chỉ định.
     * @param height Chiều cao của hình trụ.
     * @param radius Bán kính đáy của hình trụ (từ lớp Circle).
     * @param color Màu sắc của hình trụ (từ lớp Circle).
     */
    public Cylinder(double height, double radius, String color) {
        super(radius, color); // Gọi constructor của lớp cha Circle với bán kính và màu sắc
        this.height = height;
    }

    // --- Getters và Setters cho thuộc tính height ---

    /**
     * Trả về chiều cao của hình trụ.
     * @return Chiều cao hiện tại.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Đặt chiều cao mới cho hình trụ.
     * @param height Chiều cao mới.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Tính toán và trả về thể tích của hình trụ.
     * Thể tích = Diện tích đáy * Chiều cao.
     * Phương thức getArea() được kế thừa từ lớp Circle để lấy diện tích đáy.
     * @return Thể tích của hình trụ.
     */
    public double getVolume() {
        return getArea() * height; // getArea() lấy diện tích đáy từ lớp cha
    }

    /**
     * Cài đè phương thức toString() để cung cấp mô tả chi tiết về đối tượng Cylinder.
     * Bao gồm thông tin từ lớp cha Circle và thông tin về chiều cao.
     * @return Chuỗi mô tả đối tượng Cylinder.
     */
    @Override
    public String toString() {
        return "A Cylinder with height="
                + String.format("%.2f", getHeight()) // Định dạng để hiển thị 2 chữ số thập phân
                + ", which is a subclass of "
                + super.toString(); // Gọi toString() của lớp cha Circle để lấy thông tin cơ bản
    }
}
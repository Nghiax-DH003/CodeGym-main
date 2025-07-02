import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;
    private final Scanner scanner;
    // File
    private static final String FILE_PATH = "casestudy.csv";

    public ProductController() {
        this.productService = ProductService.getInstance();
        this.scanner = new Scanner(System.in);
        // File
        productService.loadFromFile(FILE_PATH);
    }

    public void run(){
        while (true) {
            System.out.println("--- MENU ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("6. Lưu sản phẩm");
            System.out.println("7. Đọc sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    saveDataToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Hiển thị
    private void showProducts() {
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        List<Product> products = productService.findAll();

        if (products.isEmpty()) {
            System.out.println("Không có sản phẩm nào.");
        } else {
            System.out.println("ID | Tên sản phẩm      | Giá        | Số lượng");
            System.out.println("-------------------------------------------------");
            for (Product p : products) {
                System.out.printf("%-2d | %-17s | %-10.1f | %d\n", p.getId(), p.getName(), p.getPrice(), p.getQuantity());
            }
        }
    }

    //Thêm
    private void addProduct() {
        System.out.println("--- THÊM SẢN PHẨM ---");
        try {
            System.out.print("Nhập ID sản phẩm: ");
            long id = Long.parseLong(scanner.nextLine());
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập số lượng sản phẩm: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product product = new Product(id, name, price, quantity);
            productService.add(product);
            System.out.println("Thêm sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập liệu. Vui lòng nhập lại.");
        }
    }

    // Xoá
    private void deleteProduct() {
        System.out.println("--- XOÁ SẢN PHẨM ---");
        try {
            System.out.print("Nhập ID sản phẩm cần xoá: ");
            long id = Long.parseLong(scanner.nextLine());

            boolean isDeleted = productService.delete(id);

            if (isDeleted) {
                System.out.println("Xoá sản phẩm thành công!");
            } else {
                System.out.println("Không tìm thấy sản phẩm với ID đã cho.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập liệu. Vui lòng nhập lại.");
        }
    }

    // Sửa
    private void updateProduct() {
        System.out.println("--- CẬP NHẬT SẢN PHẨM ---");
        try {
            System.out.print("Nhập ID sản phẩm cần cập nhật: ");
            long id = Long.parseLong(scanner.nextLine());

            if (productService.findById(id) == null) {
                System.out.println("Không tìm thấy sản phẩm với ID đã cho.");
                return;
            }

            System.out.print("Nhập tên sản phẩm mới: ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm mới: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập số lượng mới: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product updatedproduct = new Product(id, name, price, quantity);

            productService.update(updatedproduct);
            System.out.println("Cập nhật sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi nhập liệu. Vui lòng nhập lại.");
            }
    }

    // Tìm kiếm
    private void searchProductByName() {
        System.out.println("\n--- Tìm kiếm sản phẩm theo tên ---");
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String nameKeyword = scanner.nextLine();

        List<Product> foundProducts = productService.searchByName(nameKeyword);

        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào có tên chứa '" + nameKeyword + "'");
        } else {
            System.out.println("Các sản phẩm được tìm thấy:");
            System.out.println("ID | Tên sản phẩm      | Giá        | Số lượng");
            System.out.println("-------------------------------------------------");
            for (Product p : foundProducts) {
                System.out.printf("%-2d | %-17s | %-10.1f | %d\n", p.getId(), p.getName(), p.getPrice(), p.getQuantity());
            }
        }
    }

    // File
    private void saveDataToFile() {
        productService.saveToFile(FILE_PATH);
        System.out.println("Lưu dữ liệu thành công ra file: " + FILE_PATH);
    }

    private void loadFromFile() {
        productService.loadFromFile(FILE_PATH);
        System.out.println("Đọc dữ liệu từ file: " + FILE_PATH);
    }

}


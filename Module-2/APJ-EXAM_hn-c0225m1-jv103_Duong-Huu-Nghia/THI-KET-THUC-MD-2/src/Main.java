import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContactService contactService = new ContactService();
    private static final String FILE_PATH = "contacts.csv";

    public static void main(String[] args) {
        contactService.loadFromFile(FILE_PATH);
        System.out.println("Chương trình Quản lý Danh bạ!");

        while (true) {
            showMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        showAllContacts();
                        break;
                    case 2:
                        addContact();
                        break;
                    case 3:
                        updateContact();
                        break;
                    case 4:
                        deleteContact();
                        break;
                    case 5:
                        searchContact();
                        break;
                    case 6:
                        readFromFile();
                        break;
                    case 7:
                        writeToFile();
                        break;
                    case 0:
                        System.out.println("Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Chỉ nhập số");
            }
        }
    }

    // Menu
    private static void showMenu() {
        System.out.println("\n---- QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số:");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    // Hiển thị
    private static void showAllContacts() {
        System.out.println("\n--- DANH SÁCH DANH BẠ ---");
        List<Contact> contacts = contactService.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống.");
        } else {
            System.out.printf("%-15s | %-15s | %-20s\n", "Số điện thoại", "Nhóm", "Họ tên");
            System.out.println("-----------------------------------------------------");
            for (Contact contact : contacts) {
                System.out.printf("%-15s | %-15s | %-20s\n", contact.getPhoneNumber(), contact.getGroup(), contact.getFullName());
            }
        }
    }

    // Thêm
    private static void addContact() {
        System.out.println("\n--- THÊM MỚI LIÊN HỆ ---");
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        // Kiểm tra
        if (contactService.findContactByPhone(phone) != null) {
            System.out.println("Lỗi: Số điện thoại này đã tồn tại!");
            return;
        }

        System.out.print("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String dob = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(phone, group, name, gender, address, dob, email);
        contactService.addContact(newContact);
        System.out.println("Đã thêm mới thành công!");
    }

    // Sửa
    private static void updateContact() {
        System.out.println("\n--- CẬP NHẬT LIÊN HỆ ---");
        System.out.print("Nhập số điện thoại của liên hệ cần sửa: ");
        String phoneToUpdate = scanner.nextLine();

        Contact existingContact = contactService.findContactByPhone(phoneToUpdate);
        if (existingContact == null) {
            System.out.println("Không tìm thấy danh bạ với số điện thoại này.");
            return;
        }

        System.out.println("Nhập thông tin mới:");
        System.out.print("Nhóm (" + existingContact.getGroup() + "): ");
        String group = scanner.nextLine();
        if (group.isEmpty()) group = existingContact.getGroup();

        System.out.print("Họ tên (" + existingContact.getFullName() + "): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = existingContact.getFullName();

        System.out.print("Email (" + existingContact.getEmail() + "): ");
        String email = scanner.nextLine();
        if (email.isEmpty()) email = existingContact.getEmail();
        existingContact.setGroup(group);
        existingContact.setFullName(name);
        existingContact.setEmail(email);
        System.out.println("Đã cập nhật thành công!");
    }

    // Xóa
    private static void deleteContact() {
        System.out.println("\n--- XÓA LIÊN HỆ ---");
        System.out.print("Nhập số điện thoại của liên hệ cần xóa: ");
        String phoneToDelete = scanner.nextLine();
        if (contactService.deleteContact(phoneToDelete)) {
            System.out.println("Đã xóa thành công!");
        } else {
            System.out.println("Không tìm thấy liên hệ với số điện thoại này.");
        }
    }

    // Tìm kiếm
    private static void searchContact() {
        System.out.println("\n--- TÌM KIẾM ---");
        System.out.print("Nhập số điện thoại cần tìm: ");
        String keyword = scanner.nextLine();
        Contact foundContact = contactService.findContactByPhone(keyword);
        if (foundContact != null) {
            System.out.println("Đã tìm thấy: " + foundContact);
        } else {
            System.out.println("Không tìm thấy liên hệ nào.");
        }
    }

    // File
    private static void readFromFile() {
        System.out.println("\n--- ĐỌC TỪ FILE ---");
        contactService.loadFromFile(FILE_PATH);
        System.out.println("Đã cập nhật danh bạ từ file contacts.csv!");
    }

    // lưu file
    private static void writeToFile() {
        System.out.println("\n--- GHI VÀO FILE ---");
        contactService.saveToFile(FILE_PATH);
        System.out.println("Đã ghi danh bạ hiện tại vào file contacts.csv!");
    }
}
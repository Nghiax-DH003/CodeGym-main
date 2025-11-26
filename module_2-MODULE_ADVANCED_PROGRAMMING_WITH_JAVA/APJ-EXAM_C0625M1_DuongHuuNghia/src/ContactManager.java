import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<Contact> danhBa = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final String PATH = "data/contacts.csv";

    public void hienThiDanhSach() {
        if (danhBa.isEmpty()) {
            System.out.println("Danh bạ trống!");
            return;
        }
        int count = 0;
        for (Contact c : danhBa) {
            System.out.printf("%-12s | %-10s | %-15s | %-5s | %-10s | %-12s | %-20s\n",
                    c.getSoDienThoai(), c.getNhom(), c.getHoTen(), c.getGioiTinh(), c.getDiaChi(), c.getNgaySinh(), c.getEmail());
            count++;
            if (count % 5 == 0) {
                System.out.println("Nhấn Enter để xem tiếp...");
                scanner.nextLine();
            }
        }
    }

    public void themMoi() {
        String sdt;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            sdt = scanner.nextLine();
            if (sdt.matches("^\\d{10}$")) {
                break;
            }
            System.out.println("Số điện thoại phải có 10 số!");
        }

        System.out.print("Nhập nhóm: ");
        String nhom = scanner.nextLine();

        System.out.print("Nhập họ tên: ");
        String ten = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gioiTinh = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                break;
            }
            System.out.println("Email không đúng định dạng!");
        }

        danhBa.add(new Contact(sdt, nhom, ten, gioiTinh, diaChi, ngaySinh, email));
        System.out.println("Thêm mới thành công!");
    }

    public void capNhat() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String sdt = scanner.nextLine();
        Contact timThay = null;

        for (Contact c : danhBa) {
            if (c.getSoDienThoai().equals(sdt)) {
                timThay = c;
                break;
            }
        }

        if (timThay == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            return;
        }

        System.out.print("Nhập họ tên mới (Enter để giữ nguyên): ");
        String ten = scanner.nextLine();
        if (!ten.isEmpty()) timThay.setHoTen(ten);

        System.out.print("Nhập nhóm mới (Enter để giữ nguyên): ");
        String nhom = scanner.nextLine();
        if (!nhom.isEmpty()) timThay.setNhom(nhom);

        System.out.print("Nhập giới tính mới (Enter để giữ nguyên): ");
        String gt = scanner.nextLine();
        if (!gt.isEmpty()) timThay.setGioiTinh(gt);

        System.out.print("Nhập địa chỉ mới (Enter để giữ nguyên): ");
        String dc = scanner.nextLine();
        if (!dc.isEmpty()) timThay.setDiaChi(dc);

        System.out.print("Nhập ngày sinh mới (Enter để giữ nguyên): ");
        String ns = scanner.nextLine();
        if (!ns.isEmpty()) timThay.setNgaySinh(ns);

        System.out.print("Nhập email mới (Enter để giữ nguyên): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) timThay.setEmail(email);

        System.out.println("Cập nhật thành công!");
    }

    public void xoa() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String sdt = scanner.nextLine();
        Contact xoa = null;

        for (Contact c : danhBa) {
            if (c.getSoDienThoai().equals(sdt)) {
                xoa = c;
                break;
            }
        }

        if (xoa == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            return;
        }

        System.out.print("Bạn có chắc chắn muốn xóa (Y/N): ");
        String xacNhan = scanner.nextLine();
        if (xacNhan.equalsIgnoreCase("Y")) {
            danhBa.remove(xoa);
            System.out.println("Đã xóa thành công!");
            hienThiDanhSach();
        }
    }

    public void timKiem() {
        System.out.print("Nhập số điện thoại hoặc họ tên để tìm: ");
        String tuKhoa = scanner.nextLine();
        boolean coKetQua = false;

        for (Contact c : danhBa) {
            if (c.getSoDienThoai().contains(tuKhoa) || c.getHoTen().contains(tuKhoa)) {
                System.out.println(c.toString());
                coKetQua = true;
            }
        }

        if (!coKetQua) {
            System.out.println("Không tìm thấy kết quả nào.");
        }
    }

    public void docFile() {
        System.out.print("Bạn có muốn cập nhật lại bộ nhớ từ file (Y/N): ");
        String chon = scanner.nextLine();
        if (!chon.equalsIgnoreCase("Y")) return;

        danhBa.clear();
        try {
            File file = new File(PATH);
            if (!file.exists()) {
                System.out.println("File không tồn tại! Hãy chọn Ghi file trước để tạo file.");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    danhBa.add(new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            }
            br.close();
            System.out.println("Đọc file thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file.");
        }
    }

    public void ghiFile() {
        System.out.print("Bạn có muốn ghi dữ liệu vào file (Y/N): ");
        String chon = scanner.nextLine();
        if (!chon.equalsIgnoreCase("Y")) return;

        try {
            File dir = new File("data");
            if(!dir.exists()) dir.mkdir(); // Tự tạo thư mục data nếu chưa có

            BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
            bw.write("SDT,Nhom,Ten,GioiTinh,DiaChi,NgaySinh,Email");
            bw.newLine();
            for (Contact c : danhBa) {
                bw.write(c.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Ghi file thành công!");
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
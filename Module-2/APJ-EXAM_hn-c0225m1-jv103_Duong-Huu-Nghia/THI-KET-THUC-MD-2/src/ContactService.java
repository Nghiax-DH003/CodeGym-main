import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getAllContacts() {
        return contacts;
    }

    // Thêm
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // TÌm kiếm
    public Contact findContactByPhone(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    // Sửa
    public void updateContact(String phoneNumber, Contact updatedContact) {
        Contact existingContact = findContactByPhone(phoneNumber);
        if (existingContact != null) {
            existingContact.setGroup(updatedContact.getGroup());
            existingContact.setFullName(updatedContact.getFullName());
            existingContact.setGender(updatedContact.getGender());
            existingContact.setAddress(updatedContact.getAddress());
            existingContact.setDateOfBirth(updatedContact.getDateOfBirth());
            existingContact.setEmail(updatedContact.getEmail());
        }
    }

    // Xoá
    public boolean deleteContact(String phoneNumber) {
        Contact contactToDelete = findContactByPhone(phoneNumber);
        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            return true;
        }
        return false;
    }

    // Lưu
    public void saveToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            writer.newLine();
            for (Contact contact : contacts) {
                String line = String.join(",",
                        contact.getPhoneNumber(),
                        contact.getGroup(),
                        contact.getFullName(),
                        contact.getGender(),
                        contact.getAddress(),
                        contact.getDateOfBirth(),
                        contact.getEmail()
                );
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // Đọc
    public void loadFromFile(String path) {
        contacts.clear();
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File dữ liệu không tồn tại. Bắt đầu với file trống.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Contact contact = new Contact(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

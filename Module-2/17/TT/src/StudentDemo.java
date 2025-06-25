import java.io.*;

public class StudentDemo {

    public static void main(String[] args) {
        // --- BƯỚC 1: TẠO DỮ LIỆU MẪU VÀ GHI VÀO FILE ---
        try {
            System.out.println("Bắt đầu ghi file...");
            // Tạo một đối tượng sinh viên để ghi
            Student studentToWrite = new Student(1, "Nguyen Van A", 20);

            // Gọi phương thức để ghi đối tượng này vào file
            writeStudent(studentToWrite);

            System.out.println("Ghi file thành công!");

        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file!");
            e.printStackTrace();
        }

        System.out.println("------------------------------------");

        // --- BƯỚC 2: ĐỌC DỮ LIỆU TỪ FILE VÀ IN RA ---
        try {
            System.out.println("Bắt đầu đọc file...");

            // Gọi phương thức để đọc đối tượng từ file
            Student studentFromFile = readStudent();

            System.out.println("Đọc file thành công! Thông tin sinh viên:");
            // In thông tin của đối tượng vừa đọc được
            System.out.println("ID: " + studentFromFile.getId());
            System.out.println("Name: " + studentFromFile.getName());
            System.out.println("Age: " + studentFromFile.getAge());

        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file! File có thể không tồn tại hoặc bị lỗi.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy lớp Student khi đọc file.");
            e.printStackTrace();
        }
    }

    /**
     * Phương thức này ghi một đối tượng Student vào file student.dat
     * Đã sửa thành "static" để có thể gọi từ main
     */
    private static void writeStudent(Student std) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.dat"));
        oos.writeObject(std);
        oos.close();
    }

    /**
     * Phương thức này đọc một đối tượng Student từ file student.dat
     */
    public static Student readStudent() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.dat"));
        Student student = (Student) ois.readObject();
        ois.close(); // Cũng nên đóng ObjectInputStream sau khi dùng xong
        return student;
    }
}
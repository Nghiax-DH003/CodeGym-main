import java.util.Scanner;

public class FindMaxIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Tìm phần tử lớn nhất trong ma trận có sẵn ---");
        double[][] matrix = {
                {1.5, 2.7, 9.1},
                {4.2, 5.0, 3.8},
                {7.3, 8.9, 6.4}
        };

        double max_value = matrix[0][0];
        int max_row = 0;
        int max_col = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max_value) {
                    max_value = matrix[i][j];
                    max_row = i;
                    max_col = j;
                }
            }
        }

        System.out.println("Ma trận có sẵn:");
        printMatrix(matrix);

        System.out.println("\nKết quả tìm kiếm trong ma trận có sẵn:");
        System.out.println("Phần tử lớn nhất là: " + max_value);
        System.out.println("Tọa độ của phần tử lớn nhất là: (" + max_row + ", " + max_col + ")");
        System.out.println("--------------------------------------------------\n");

        System.out.println("--- Tìm phần tử lớn nhất trong ma trận từ người dùng ---");
        System.out.print("Nhập số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Kích thước ma trận phải là số dương. Chương trình kết thúc.");
            scanner.close();
            return;
        }

        double[][] userMatrix = new double[rows][cols];

        System.out.println("Nhập các phần tử cho ma trận:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Nhập phần tử tại vị trí [%d][%d]: ", i, j);
                userMatrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\nMa trận bạn đã nhập:");
        printMatrix(userMatrix);

        double max_value_user = userMatrix[0][0];
        int max_row_user = 0;
        int max_col_user = 0;

        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                if (userMatrix[i][j] > max_value_user) {
                    max_value_user = userMatrix[i][j];
                    max_row_user = i;
                    max_col_user = j;
                }
            }
        }

        System.out.println("\nKết quả tìm kiếm trong ma trận của bạn:");
        System.out.println("Phần tử lớn nhất là: " + max_value_user);
        System.out.println("Tọa độ của phần tử lớn nhất là: (" + max_row_user + ", " + max_col_user + ")");

        scanner.close();
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.1f  ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

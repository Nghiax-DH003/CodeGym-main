import java.util.Scanner;

public class PrimeNumbersDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng số nguyên tố bạn muốn hiển thị: ");
        int numbers = scanner.nextInt();

        int count = 0;
        int N = 2;

        System.out.println("------------------------------------");
        System.out.println(numbers + " số nguyên tố đầu tiên là:");

        while (count < numbers) {
            boolean isPrime = true;

            if (N < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(N); i++) {
                    if (N % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.print(N + " ");
                count++;
            }

            N++;
        }
        System.out.println("\n------------------------------------");
        scanner.close();
    }
}

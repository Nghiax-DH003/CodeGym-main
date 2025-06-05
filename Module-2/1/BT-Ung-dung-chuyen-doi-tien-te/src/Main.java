import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double rate = 23000.0;
        System.out.println(rate);

        Scanner input = new Scanner(System.in);
        double usdValue;

        System.out.println("Nhap tien: ");
        usdValue = input.nextDouble();
        double vndRate = usdValue * rate;
        System.out.println(usdValue + " USD= " + vndRate + " VND");
    }
}
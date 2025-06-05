import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên không âm (tối đa 3 chữ số): ");
        int number = input.nextInt();

        String words = "";

        if (number < 0 || number > 999) { // Số không hợp lệ hoặc quá khả năng
            words = "Out of ability";
        } else {
            // Xử lý các số có 3 chữ số
            if (number >= 100) {
                int hundreds = number / 100;
                int remainder = number % 100;

                // Đọc hàng trăm
                words = readOneDigitNumber(hundreds) + " hundred";

                // Xử lý phần còn lại (remainder)
                if (remainder > 0) { // Nếu có phần dư (ví dụ 261, 405)
                    words += " and "; // Thêm "and"
                    if (remainder < 10) { // 201 -> "two hundred and one"
                        words += readOneDigitNumber(remainder);
                    } else if (remainder < 20) { // 215 -> "two hundred and fifteen"
                        words += readTeensNumber(remainder);
                    } else { // 261 -> "two hundred and sixty one"
                        int tens = remainder / 10;
                        int ones = remainder % 10;
                        words += readTensDigit(tens);
                        if (ones != 0) { // Chỉ thêm hàng đơn vị nếu nó khác 0
                            words += " " + readOneDigitNumber(ones);
                        }
                    }
                }
            } else if (number >= 20) { // Xử lý các số từ 20 đến 99
                int tens = number / 10;
                int ones = number % 10;

                String tensWord = readTensDigit(tens);
                String onesWord = readOneDigitNumber(ones);

                if (ones == 0) {
                    words = tensWord;
                } else {
                    words = tensWord + " " + onesWord;
                }
            } else if (number >= 10) { // Xử lý các số từ 10 đến 19
                words = readTeensNumber(number);
            } else { // Xử lý các số từ 0 đến 9
                words = readOneDigitNumber(number);
            }
        }

        System.out.println("------------------------------------");
        System.out.println("Số " + number + " được đọc là: " + words);
        System.out.println("------------------------------------");

        input.close();
    }

    // --- Các hàm trợ giúp (Helper methods) ---
    // Đặt các hàm này bên ngoài hàm main() nhưng bên trong class NumberToWords

    public static String readOneDigitNumber(int num) {
        // Hàm này không cần xử lý số 0 nếu nó là hàng đơn vị (ví dụ "four hundred and five" thay vì "four hundred and zero five")
        // Tuy nhiên, đối với số 0 duy nhất, vẫn cần trả về "zero".
        if (num == 0) {
            return "zero"; // Dùng cho trường hợp số = 0
        }
        switch (num) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    public static String readTeensNumber(int num) {
        switch (num) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    public static String readTensDigit(int tens) {
        switch (tens) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";
        }
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        DictionaryController controller = new DictionaryController();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Action: ");

        String command = scanner.nextLine();

        controller.execute(command);

        scanner.close();
        
    }
}
import java.util.Scanner;

public class verification {
    static Scanner scanner = new Scanner(System.in);
    public static String trueFalse(String description) {
        String value = "";
        while (!value.equals("tak") && !value.equals("nie")) {
            System.out.print(description);
            value = scanner.nextLine();
        }
        return value;
    }

    public static String openClosed(String description) {
        String value = "";
        while (!value.equals("otwarte") && !value.equals("zamknięte")) {
            System.out.print(description);
            value = scanner.nextLine();
        }
        return value;
    }
}

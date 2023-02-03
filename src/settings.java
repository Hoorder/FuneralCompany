import java.util.Scanner;

public class settings {
    static Scanner scanner = new Scanner(System.in);

    public static void changePassword(String loginDB, String hasloDB) {
        System.out.println("- Zmień hasło -");
        System.out.println("-----------------------");

        System.out.print("Podaj obecne hasło: ");
        String stareHaslo = scanner.nextLine();

        if (stareHaslo.equals(hasloDB)) {
            System.out.print("Podaj nowe hasło: ");
            String noweHaslo = scanner.nextLine();

            String zapytanie = "UPDATE `konta` SET `haslo`='"+noweHaslo+"' WHERE login ='"+loginDB+"'";
            queryExecutor.executeQuery(zapytanie);

            System.out.println(" ");
            System.out.println("Pomyślnie dodano do Bazy Danych");
            System.out.println("Zostaniesz wylogowany...");
            signIn.logowanie();
            System.out.println(" ");
        } else {
            System.out.println("Błędne hasło, podaj nowe");
            changePassword(loginDB, hasloDB);
        }

    }
}

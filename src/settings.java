import java.util.Scanner;

public class settings {
    static Scanner scanner = new Scanner(System.in);

    public static void changePassword(String loginDB, String hasloDB) {
        System.out.println("-----------------------");
        System.out.println("- Zmień hasło -");
        System.out.println("-----------------------");

        System.out.print("Podaj obecne hasło: ");
        String stareHaslo = scanner.nextLine();

        if (stareHaslo.equals(hasloDB)) {
            System.out.println("(Hasła powinny być różne)");
            System.out.print("Podaj nowe hasło: ");
            String noweHaslo = scanner.nextLine();

            if (!stareHaslo.equals(noweHaslo)) {
                String zapytanie = "UPDATE `konta` SET `haslo`='"+noweHaslo+"' WHERE login ='"+loginDB+"'";
                queryExecutor.executeQuery(zapytanie);

                System.out.println(" ");
                System.out.println("Zmieniono hasło");
                System.out.println("Zostaniesz wylogowany...");
                signIn.logowanie();
                System.out.println(" ");
            } else {
                System.out.println("Hasła nie mogą być takie same");
                changePassword(loginDB, hasloDB);
            }

        } else {
            System.out.println("Błędne hasło, podaj nowe");
            changePassword(loginDB, hasloDB);
        }

    }
}

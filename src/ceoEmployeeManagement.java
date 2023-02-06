import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ceoEmployeeManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void showEmployees(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_konta`, `login`, `imie`, `stanowisko` FROM `konta`";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_konta");
                String table2 = resultPracownik.getString("login");
                String table3 = resultPracownik.getString("imie");
                String table4 = resultPracownik.getString("stanowisko");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Id. Pracownika: " + table1 + " - Login: " + table2 + " - Imię: " + table3 + " - Pełnione stanowisko: " +table4);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addManager() {
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();

        String zapytanie = "INSERT INTO `konta`(`login`, `haslo`, `imie`, `stanowisko`) VALUES ('"+login+"','"+haslo+"','"+imie+"','kierownik')";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Dodano kierownika");
        System.out.println(" ");
    };

    public static void removeManager(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_konta`, `login`, `imie`, `stanowisko` FROM `konta` WHERE `stanowisko` = 'kierownik'";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_konta");
                String table2 = resultPracownik.getString("login");
                String table3 = resultPracownik.getString("imie");
                String table4 = resultPracownik.getString("stanowisko");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Id. Pracownika: " + table1 + " - Login: " + table2 + " - Imię: " + table3 + " - Pełnione stanowisko: " +table4);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--");
        System.out.print("Podaj login konta, które chcesz usunąć: ");
        String login = scanner.nextLine();

        String zapytanie = "DELETE FROM `konta` WHERE `login` = '"+login+"' AND `stanowisko` = 'kierownik'";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Usunięto kierownika");
        System.out.println(" ");
    };

    public static void addWorker() {
        System.out.print("Podaj login: ");
        String login = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        String haslo = scanner.nextLine();
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();

        String zapytanie = "INSERT INTO `konta`(`login`, `haslo`, `imie`, `stanowisko`) VALUES ('"+login+"','"+haslo+"','"+imie+"','pracownik')";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Dodano pracownika");
        System.out.println(" ");
    };

    public static void removeWorker(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_konta`, `login`, `imie`, `stanowisko` FROM `konta` WHERE `stanowisko` = 'pracownik'";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_konta");
                String table2 = resultPracownik.getString("login");
                String table3 = resultPracownik.getString("imie");
                String table4 = resultPracownik.getString("stanowisko");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Id. Pracownika: " + table1 + " - Login: " + table2 + " - Imię: " + table3 + " - Pełnione stanowisko: " +table4);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--");
        System.out.print("Podaj login konta, które chcesz usunąć: ");
        String login = scanner.nextLine();

        String zapytanie = "DELETE FROM `konta` WHERE `login` = '"+login+"' AND `stanowisko` = 'pracownik'";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Usunięto pracownika");
        System.out.println(" ");
    };

    public static void changeRank(String stanowiskoDB) {
        showEmployees(stanowiskoDB);

        System.out.println(" ");
        System.out.print("Podaj login konta, którego rangę chcesz zmienić: ");
        String login = scanner.nextLine();

        try {
            String zapytanie = "SELECT `id_konta`, `login`, `imie`, `stanowisko` FROM `konta` WHERE login = '"+login+"'";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_konta");
                String table2 = resultPracownik.getString("login");
                String table3 = resultPracownik.getString("imie");
                String table4 = resultPracownik.getString("stanowisko");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("--");
                    System.out.println("Id. Pracownika: " + table1 + " - Login: " + table2 + " - Imię: " + table3 + " - Pełnione stanowisko: " +table4);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Podaj nazwę nowego stanowiska: ");
        String stanowisko = scanner.nextLine();

        String zapytanie = "UPDATE `konta` SET `stanowisko`='"+stanowisko+"' WHERE `login` = '"+login+"'";
        queryExecutor.executeQuery(zapytanie);
    };
}

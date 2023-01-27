import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class signIn {

    public static void logowanie() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("-----------------------");
            System.out.println("Funeral Central System");
            System.out.println("-----------------------");
            System.out.print("Podaj login: ");
            String login = scanner.nextLine();
            System.out.print("Podaj hasło: ");
            String haslo = scanner.nextLine();

            ResultSet result = queryExecutor.executeSelect("SELECT * FROM `konta` WHERE login='" + login + "'");

            if (result.next()) {
                String loginDB = result.getString("login");
                String hasloDB = result.getString("haslo");
                String imieDB = result.getString("imie");
                String stanowiskoDB = result.getString("stanowisko");

                if (login.equals(loginDB) && haslo.equals(hasloDB)) {
                    switch (stanowiskoDB) {

                        case "szef" -> ceo.showResponsibilities(loginDB, imieDB, stanowiskoDB);

                        case "kierownik" -> manager.showResponsibilities(loginDB, imieDB, stanowiskoDB);

                        case "pracownik" -> worker.showResponsibilities(loginDB, imieDB, stanowiskoDB);

                    }
                } else {
                    System.out.println("Niepoprawne hasło");
                    logowanie();
                }
            } else {
                System.out.println("Niepoprawny login lub hasło");
                logowanie();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

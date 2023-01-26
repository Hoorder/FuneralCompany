import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Pobieranie danych logowania od użytkownika
            System.out.print("Podaj login: ");
            String login = scanner.nextLine();
            System.out.print("Podaj hasło: ");
            String haslo = scanner.nextLine();

            // Pobieranie danych z bazy danych podanego loginu - sprawdzenie czy istnieje
            ResultSet result = queryExecutor.executeSelect("SELECT * FROM `konta` WHERE login='" + login + "'");

            if (result.next()) {
                String loginDB = result.getString("login");
                String hasloDB = result.getString("haslo");
                String imieDB = result.getString("imie");
                String stanowiskoDB = result.getString("stanowisko");

                // Sprawdzanie poprawności danych logowania
                if (login.equals(loginDB) && haslo.equals(hasloDB)) {

                    switch (stanowiskoDB) {
                        case "szef" -> {
                            System.out.println("Dzień dobry "+imieDB+"");
                            break;
                        }

                        case "kierownik" -> {
                            System.out.println("Cześć "+imieDB+"");
                            manager.showFunerals(loginDB, stanowiskoDB);
                            break;
                        }

                        case "pracownik" -> {
                            System.out.println("Witaj "+imieDB+"");
                            worker.showFunerals(loginDB, stanowiskoDB);
                            break;
                        }
                    }

                } else {
                    System.out.println("Niepoprawne hasło");
                }

            } else {
                System.out.println("Niepoprawny login lub hasło");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
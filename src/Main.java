import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
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
                            break;
                        }

                        case "pracownik" -> {
                            System.out.println("Witaj "+imieDB+"");

                            System.out.println("1. Wyświetl pogrzeby");
                            System.out.println("2. Wyloguj");
                            System.out.print("Wybierz opcje: ");

                            int choice = scanner.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("------------------------------");
                                    System.out.println("Oto twoje najbliższe pogrzeby:");
                                    System.out.println("------------------------------");

                                    try {
                                        String zapytanie = "SELECT obsluga.kierownik_kierowca, pogrzeb.data_pogrzebu,pogrzeb.godzina_pogrzebu,pogrzeb.miejsce_pochowku FROM pogrzeb JOIN obsluga ON pogrzeb.id_pogrzebu = obsluga.id_pogrzebu WHERE '"+loginDB+"' IN (obsluga.zalobnik_1, obsluga.zalobnik_2, obsluga.zalobnik_3, obsluga.zalobnik_4, obsluga.zalobnik_5, obsluga.zalobnik_6, obsluga.zalobnik_7) AND status_zlecenia = 'otwarte'";
                                        ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

                                        while (resultPracownik.next()) {
                                            String table1 = resultPracownik.getString("kierownik_kierowca");
                                            String table2 = resultPracownik.getString("data_pogrzebu");
                                            String table3 = resultPracownik.getString("godzina_pogrzebu");
                                            String table4 = resultPracownik.getString("miejsce_pochowku");

                                            System.out.println("Kierownik: " + table1);
                                            System.out.println("Data: " + table2);
                                            System.out.println("Godzina: " + table3);
                                            System.out.println("Miejscowość: " + table4);
                                            System.out.println("--");
                                        }
                                    }
                                    catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }

                                    System.out.println("1. Wyjdź");
                                    System.out.print("Wybierz opcje: ");
                                    int wyjdz = scanner.nextInt();
                                    break;


                                case 2:
                                    System.out.println("Wylogowywanie...");
                                    break;

                                default:
                                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                                    break;
                            }




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
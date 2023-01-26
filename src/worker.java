import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class worker {
    public static void showResponsibilities(String loginDB, String imieDB, String stanowiskoDB) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Witaj "+imieDB+"");

            System.out.println("1. Wyświetl obsługi");
            System.out.println("2. Wyloguj");
            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("------------------------------");
                    System.out.println("Twoja najbliższe obsługi:");
                    System.out.println("------------------------------");
                    try {

                        String zapytanie = "SELECT obsluga.kierownik_kierowca, pogrzeb.data_pogrzebu,pogrzeb.godzina_pogrzebu,pogrzeb.miejsce_pochowku FROM pogrzeb JOIN obsluga ON pogrzeb.id_pogrzebu = obsluga.id_pogrzebu WHERE '" + loginDB + "' IN (obsluga.zalobnik_1, obsluga.zalobnik_2, obsluga.zalobnik_3, obsluga.zalobnik_4, obsluga.zalobnik_5, obsluga.zalobnik_6, obsluga.zalobnik_7) AND status_zlecenia = 'otwarte'";
                        ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

                        while (resultPracownik.next()) {

                            String table1 = resultPracownik.getString("kierownik_kierowca");
                            String table2 = resultPracownik.getString("data_pogrzebu");
                            String table3 = resultPracownik.getString("godzina_pogrzebu");
                            String table4 = resultPracownik.getString("miejsce_pochowku");

                            if ("pracownik".equals(stanowiskoDB)) {
                                System.out.println("Kierownik: " + table1);
                                System.out.println("Data: " + table2);
                                System.out.println("Godzina: " + table3);
                                System.out.println("Miejscowość: " + table4);
                                System.out.println("--");
                            }

                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("1. Cofnij");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("Wylogowywanie...");
                    signIn.logowanie();
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

    }

}

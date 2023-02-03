import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class manager {
    public static void showResponsibilities(String loginDB, String hasloDB, String imieDB, String stanowiskoDB) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Cześć "+imieDB+"");

            System.out.println("1. Wyświetl listę pogrzebów");
            System.out.println("2. Wyświetl liste nagrobków");
            System.out.println("3. Ustawienia");
            System.out.println("4. Wyloguj");
            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {

                    System.out.println("------------------------------");
                    System.out.println("Twoje najbliższe pogrzeby:");
                    System.out.println("------------------------------");
                    try {

                        String zapytanie = "SELECT obsluga.id_pogrzebu, pogrzeb.data_pogrzebu,pogrzeb.godzina_pogrzebu,pogrzeb.miejsce_pochowku,pogrzeb.rodzaj_trumny_urny,pogrzeb.jaki_karawan,pogrzeb.krzyz,pogrzeb.tabliczka,pogrzeb.kwiaty, obsluga.zalobnik_1, obsluga.zalobnik_2, obsluga.zalobnik_3, obsluga.zalobnik_4, obsluga.zalobnik_5, obsluga.zalobnik_6, obsluga.zalobnik_7 FROM pogrzeb JOIN obsluga ON pogrzeb.id_pogrzebu = obsluga.id_pogrzebu WHERE obsluga.kierownik_kierowca = '"+loginDB+"' AND pogrzeb.status_zlecenia = 'otwarte';";
                        ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

                        while (resultPracownik.next()) {

                            String table1 = resultPracownik.getString("id_pogrzebu");
                            String table2 = resultPracownik.getString("data_pogrzebu");
                            String table3 = resultPracownik.getString("godzina_pogrzebu");
                            String table4 = resultPracownik.getString("miejsce_pochowku");
                            String table5 = resultPracownik.getString("rodzaj_trumny_urny");
                            String table6 = resultPracownik.getString("jaki_karawan");
                            String table7 = resultPracownik.getString("krzyz");
                            String table8 = resultPracownik.getString("tabliczka");
                            String table9 = resultPracownik.getString("kwiaty");
                            String table10 = resultPracownik.getString("zalobnik_1");
                            String table11 = resultPracownik.getString("zalobnik_2");
                            String table12 = resultPracownik.getString("zalobnik_3");
                            String table13 = resultPracownik.getString("zalobnik_4");
                            String table14 = resultPracownik.getString("zalobnik_5");
                            String table15 = resultPracownik.getString("zalobnik_6");
                            String table16 = resultPracownik.getString("zalobnik_7");

                            if ("kierownik".equals(stanowiskoDB)) {
                                System.out.println("id pogrzebu: " + table1);
                                System.out.println("Data pogrzebu: " + table2 + " - Godzina: " + table3 + " - Miejscowość: " + table4);
                                System.out.println("Rodzaj trumny: " + table5 + " - Karawan: " + table6);
                                System.out.println("Odebrać z biura: Krzyż: " + table7 + " - Tabliczka: " + table8 + " - kwiaty: " + table9);
                                System.out.println("Skład obsługi: " + table10 + " " + table11 + " " + table12 + " " + table13 + " " + table14 + " " + table15 + " " + table16);
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
                    System.out.println("------------------------------");
                    System.out.println("Twoje zlecenia:");
                    System.out.println("------------------------------");
                    try {

                        String zapytanie = "SELECT `id_zlecenia`,`miejscowosc`,`data_oddania`,`nazwa_kamienia`,`styl_nagrobka`,`piwniczka`,`ilosc_osob` FROM `kamieniarstwo` WHERE kierownik_prac = '"+loginDB+"';";
                        ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

                        while (resultPracownik.next()) {

                            String table1 = resultPracownik.getString("id_zlecenia");
                            String table2 = resultPracownik.getString("miejscowosc");
                            String table3 = resultPracownik.getString("data_oddania");
                            String table4 = resultPracownik.getString("nazwa_kamienia");
                            String table5 = resultPracownik.getString("styl_nagrobka");
                            String table6 = resultPracownik.getString("piwniczka");
                            String table7 = resultPracownik.getString("ilosc_osob");

                            if ("kierownik".equals(stanowiskoDB)) {
                                System.out.println("Nr. zlecenia: " + table1);
                                System.out.println("Miejscowość: " + table2 + " - Data oddania: " + table3);
                                System.out.println("Nazwa kamienia: " + table4 + " - Styl nagrobka: " + table5);
                                System.out.println("Piwniczka: " + table6 + " - Na: " + table7 + " osób");
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
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ustawienia -");
                    System.out.println("-----------------------");

                    settings.changePassword(loginDB, hasloDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("Wylogowywanie...");
                    signIn.logowanie();
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

    }

}

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ceoFuneralServices {
    static Scanner scanner = new Scanner(System.in);

    public static void numberOfFunerals(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT kierownik_kierowca, COUNT(*) as ilosc_zlecen FROM obsluga JOIN pogrzeb ON obsluga.id_obslugi = pogrzeb.id_pogrzebu WHERE status_zlecenia = 'otwarte' GROUP BY kierownik_kierowca;";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("kierownik_kierowca");
                String table2 = resultPracownik.getString("ilosc_zlecen");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Kierownik: " + table1 + " - Ilość obsług: " + table2);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addFuneral() {
        System.out.print("Imie nazwisko klienta: ");
        String value2 = scanner.nextLine();
        System.out.print("Nr. Tel klienta: ");
        String value3 = scanner.nextLine();
        System.out.print("Adres klienta: ");
        String value4 = scanner.nextLine();
        System.out.print("Imie nazwisko denata: ");
        String value5 = scanner.nextLine();
        System.out.print("Data urodzenia (rrrr-mm-dd): ");
        String value6 = scanner.nextLine();
        System.out.print("Data śmierci (rrrr-mm-dd): ");
        String value7 = scanner.nextLine();
        System.out.print("Wiek: ");
        String value8 = scanner.nextLine();
        System.out.print("Data pogrzebu (rrrr-mm-dd): ");
        String value9 = scanner.nextLine();
        System.out.print("Godzina pogrzebu (hh-mm-ss): ");
        String value10 = scanner.nextLine();
        System.out.print("Miejsce pochówku: ");
        String value11 = scanner.nextLine();
        System.out.print("Trumna/Urna: ");
        String value12 = scanner.nextLine();
        System.out.print("Rodzaj Trumny/Urny: ");
        String value13 = scanner.nextLine();
        System.out.print("Ilość Żałobników: ");
        String value14 = scanner.nextLine();
        System.out.print("Karawan: ");
        String value15 = scanner.nextLine();
        System.out.print("Krzyż: ");
        String value16 = scanner.nextLine();
        System.out.print("Tabliczka: ");
        String value17 = scanner.nextLine();
        System.out.print("Kwiaty: ");
        String value18 = scanner.nextLine();
        System.out.print("Przygotowanie zasiłku: ");
        String value19 = scanner.nextLine();
        System.out.print("Cena: ");
        String value20 = scanner.nextLine();
        System.out.print("Status zlecenia: ");
        String value21 = scanner.nextLine();

        String zapytanie = "INSERT INTO `pogrzeb`(`personalia_czlonka_rodziny`, `nr_tel_czlonka_rodziny`, `adres_czlonka_rodziny`, `personalia_denata`, `data_urodzenia`, `data_smierci`, `wiek`, `data_pogrzebu`, `godzina_pogrzebu`, `miejsce_pochowku`, `trumna`, `rodzaj_trumny_urny`, `ilosc_osob_na_obsludze`, `jaki_karawan`, `krzyz`, `tabliczka`, `kwiaty`, `przygotowanie_zasilku`, `cena`, `status_zlecenia`) VALUES ('"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6+"','"+value7+"','"+value8+"','"+value9+"','"+value10+"','"+value11+"','"+value12+"','"+value13+"','"+value14+"','"+value15+"','"+value16+"','"+value17+"','"+value18+"','"+value19+"','"+value20+"','"+value21+"')";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Pomyślnie dodano do Bazy Danych");
        System.out.println(" ");
    }

    public static void addFuneralDirectors(String stanowiskoDB) {

        try {
            String zapytanie = "SELECT pogrzeb.id_pogrzebu, pogrzeb.ilosc_osob_na_obsludze, obsluga.kierownik_kierowca, obsluga.zalobnik_1 , obsluga.zalobnik_2, obsluga.zalobnik_3, obsluga.zalobnik_4, obsluga.zalobnik_5, obsluga.zalobnik_6, obsluga.zalobnik_7, pogrzeb.status_zlecenia FROM obsluga RIGHT JOIN pogrzeb ON obsluga.id_pogrzebu = pogrzeb.id_pogrzebu WHERE pogrzeb.status_zlecenia = 'otwarte';";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_pogrzebu");
                String table2 = resultPracownik.getString("ilosc_osob_na_obsludze");
                String table3 = resultPracownik.getString("kierownik_kierowca");
                String table4 = resultPracownik.getString("zalobnik_1");
                String table5 = resultPracownik.getString("zalobnik_2");
                String table6 = resultPracownik.getString("zalobnik_3");
                String table7 = resultPracownik.getString("zalobnik_4");
                String table8 = resultPracownik.getString("zalobnik_5");
                String table9 = resultPracownik.getString("zalobnik_6");
                String table10 = resultPracownik.getString("zalobnik_7");
                String table11 = resultPracownik.getString("status_zlecenia");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Nr. pogrzebu: " + table1);
                    System.out.println("Wymagana ilość osób: " + table2);
                    System.out.println("Kierownik/kierowca: " + table3);
                    System.out.println("1.Żałobnik: " + table4);
                    System.out.println("2.Żałobnik: " + table5);
                    System.out.println("3.Żałobnik: " + table6);
                    System.out.println("4.Żałobnik: " + table7);
                    System.out.println("5.Żałobnik: " + table8);
                    System.out.println("6.Żałobnik: " + table9);
                    System.out.println("7.Żałobnik: " + table10);
                    System.out.println("Status zlecenia: " + table11);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Dodaj obsługę");
        System.out.println("--");

        System.out.print("Podaj nr. pogrzebu: ");
        String value1 = scanner.nextLine();
        System.out.print("Kierownik/kierowca: ");
        String value2 = scanner.nextLine();
        System.out.print("1.Żałobnik: ");
        String value3 = scanner.nextLine();
        System.out.print("2.Żałobnik: ");
        String value4 = scanner.nextLine();
        System.out.print("3.Żałobnik: ");
        String value5 = scanner.nextLine();
        System.out.print("4.Żałobnik: ");
        String value6 = scanner.nextLine();
        System.out.print("5.Żałobnik: ");
        String value7 = scanner.nextLine();
        System.out.print("6.Żałobnik: ");
        String value8 = scanner.nextLine();
        System.out.print("7.Żałobnik: ");
        String value9 = scanner.nextLine();

        String zapytanie = "INSERT INTO `obsluga`(`id_pogrzebu`, `kierownik_kierowca`, `zalobnik_1`, `zalobnik_2`, `zalobnik_3`, `zalobnik_4`, `zalobnik_5`, `zalobnik_6`, `zalobnik_7`) VALUES ('"+value1+"','"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6+"','"+value7+"','"+value8+"','"+value9+"')";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Pomyślnie dodano obsługe do pogrzebu");
        System.out.println(" ");
    }

    public static void activeOrders(String stanowiskoDB) {

        try {
            String zapytanie = "SELECT pogrzeb.id_pogrzebu, obsluga.kierownik_kierowca, obsluga.zalobnik_1 , obsluga.zalobnik_2, obsluga.zalobnik_3, obsluga.zalobnik_4, obsluga.zalobnik_5, obsluga.zalobnik_6, obsluga.zalobnik_7, pogrzeb.ilosc_osob_na_obsludze, pogrzeb.jaki_karawan, pogrzeb.personalia_denata, pogrzeb.data_pogrzebu, pogrzeb.godzina_pogrzebu, pogrzeb.miejsce_pochowku FROM obsluga RIGHT JOIN pogrzeb ON obsluga.id_pogrzebu = pogrzeb.id_pogrzebu WHERE pogrzeb.status_zlecenia = 'otwarte';";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_pogrzebu");
                String table2 = resultPracownik.getString("kierownik_kierowca");
                String table3 = resultPracownik.getString("zalobnik_1");
                String table4 = resultPracownik.getString("zalobnik_2");
                String table5 = resultPracownik.getString("zalobnik_3");
                String table6 = resultPracownik.getString("zalobnik_4");
                String table7 = resultPracownik.getString("zalobnik_5");
                String table8 = resultPracownik.getString("zalobnik_6");
                String table9 = resultPracownik.getString("zalobnik_7");
                String table10 = resultPracownik.getString("ilosc_osob_na_obsludze");
                String table11 = resultPracownik.getString("jaki_karawan");
                String table12 = resultPracownik.getString("personalia_denata");
                String table13 = resultPracownik.getString("data_pogrzebu");
                String table14 = resultPracownik.getString("godzina_pogrzebu");
                String table15 = resultPracownik.getString("miejsce_pochowku");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Nr. Pogrzebu: " + table1);
                    System.out.println("Ilość osób: " + table10);
                    System.out.println("Kierownik/kierowca: " + table2);
                    System.out.println("1.Żałobnik: " + table3 + " 2.Żałobnik: " + table4 + " 3.Żałobnik: " + table5 + " 4.Żałobnik: " + table6 + " 5.Żałobnik: " + table7 + " 6.Żałobnik: " + table8 + " 7.Żałobnik: " + table9);
                    System.out.println("Karawan: " + table11);
                    System.out.println("Personalia denata: " + table12);
                    System.out.println("Data pogrzebu: " + table13);
                    System.out.println("Godzina pogrzebu: " + table14);
                    System.out.println("Miejsce pochówku: " + table15);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void allOrders(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_pogrzebu`,`personalia_czlonka_rodziny`,`nr_tel_czlonka_rodziny`,`adres_czlonka_rodziny`,`personalia_denata`,`data_urodzenia`,`data_smierci`,`wiek`,`data_pogrzebu`,`godzina_pogrzebu`,`miejsce_pochowku`,`trumna`,`rodzaj_trumny_urny`,`ilosc_osob_na_obsludze`,`jaki_karawan`,`krzyz`,`tabliczka`,`kwiaty`,`przygotowanie_zasilku`,`cena`,`status_zlecenia` FROM pogrzeb;";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_pogrzebu");
                String table2 = resultPracownik.getString("personalia_czlonka_rodziny");
                String table3 = resultPracownik.getString("nr_tel_czlonka_rodziny");
                String table4 = resultPracownik.getString("adres_czlonka_rodziny");
                String table5 = resultPracownik.getString("personalia_denata");
                String table6 = resultPracownik.getString("data_urodzenia");
                String table7 = resultPracownik.getString("data_smierci");
                String table8 = resultPracownik.getString("wiek");
                String table9 = resultPracownik.getString("data_pogrzebu");
                String table10 = resultPracownik.getString("godzina_pogrzebu");
                String table11 = resultPracownik.getString("miejsce_pochowku");
                String table12 = resultPracownik.getString("trumna");
                String table13 = resultPracownik.getString("rodzaj_trumny_urny");
                String table14 = resultPracownik.getString("ilosc_osob_na_obsludze");
                String table15 = resultPracownik.getString("jaki_karawan");
                String table16 = resultPracownik.getString("krzyz");
                String table17 = resultPracownik.getString("tabliczka");
                String table18 = resultPracownik.getString("kwiaty");
                String table19 = resultPracownik.getString("przygotowanie_zasilku");
                String table20 = resultPracownik.getString("cena");
                String table21 = resultPracownik.getString("status_zlecenia");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Nr. Pogrzebu: " + table1);
                    System.out.println("Imie nazwisko klienta: " + table2);
                    System.out.println("Nr. Tel klienta: " + table3);
                    System.out.println("Adres klienta: " + table4);
                    System.out.println("Imie nazwisko denata: " + table5);
                    System.out.println("Data urodzenia (rrrr-mm-dd): " + table6);
                    System.out.println("Data śmierci (rrrr-mm-dd): " + table7);
                    System.out.println("Wiek: " + table8);
                    System.out.println("Data pogrzebu (rrrr-mm-dd): " + table9);
                    System.out.println("Godzina pogrzebu (hh-mm-ss): " + table10);
                    System.out.println("Miejsce pochówku: " + table11);
                    System.out.println("Trumna/Urna: " + table12);
                    System.out.println("Rodzaj Trumny/Urny: " + table13);
                    System.out.println("Ilość Żałobników: " + table14);
                    System.out.println("Karawan: " + table15);
                    System.out.println("Krzyż: " + table16);
                    System.out.println("Tabliczka: " + table17);
                    System.out.println("Kwiaty: " + table18);
                    System.out.println("Przygotowanie zasiłku: " + table19);
                    System.out.println("Cena: " + table20);
                    System.out.println("Status zlecenia: " + table21);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeOrder(String stanowiskoDB) {
        activeOrders(stanowiskoDB);

        System.out.print("Podaj Nr. Pogrzebu, który jest do usunięcia: ");
        int funeralID = scanner.nextInt();
        String zapytanie = "DELETE FROM `pogrzeb` WHERE id_pogrzebu = "+funeralID+"";
        queryExecutor.executeQuery(zapytanie);
    }

    public static void removeFuneralDirectors(String stanowiskoDB) {
        activeOrders(stanowiskoDB);

        System.out.print("Podaj Id.Pogrzebu, którego obsługa jest do usunięcia: ");
        int funeralID = scanner.nextInt();
        String zapytanie = "DELETE FROM `obsluga` WHERE id_pogrzebu = "+funeralID+"";
        queryExecutor.executeQuery(zapytanie);
    }

    public static void changeStatus(String stanowiskoDB) {
        allOrders(stanowiskoDB);

        System.out.print("Podaj id. pogrzebu: ");
        int idPogrzebu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj nowy status (otwarte/zamknięte): ");
        String statusPogrzebu = scanner.nextLine();

        String zapytanie = "UPDATE `pogrzeb` SET `status_zlecenia`='"+statusPogrzebu+"' WHERE `id_pogrzebu` = '"+idPogrzebu+"'";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Pomyślnie zmieniono status pogrzebu");
        System.out.println(" ");
    }
}

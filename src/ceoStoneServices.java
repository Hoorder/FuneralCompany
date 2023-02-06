import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ceoStoneServices {
    static Scanner scanner = new Scanner(System.in);

    public static void numberOfOrders(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT kierownik_prac, COUNT(*) as ilosc_zlecen FROM kamieniarstwo WHERE status_zlecenia = 'otwarte' GROUP BY kierownik_prac";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("kierownik_prac");
                String table2 = resultPracownik.getString("ilosc_zlecen");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Kierownik: " + table1 + " - Ilość zleceń: " + table2);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addOrder(String stanowiskoDB) {
        numberOfOrders(stanowiskoDB);
        System.out.println(" ");

        System.out.print("Kierownik prac: ");
        String value2 = scanner.nextLine();
        System.out.print("Personalia klienta: ");
        String value3 = scanner.nextLine();
        System.out.print("Usługa dodatkowa do pogrzebu o id: ");
        String value4 = scanner.nextLine();
        System.out.print("Miejscowość: ");
        String value5 = scanner.nextLine();
        System.out.print("Data oddania (rrrr-mm-dd): ");
        String value6 = scanner.nextLine();
        System.out.print("Nazwa kamienia: ");
        String value7 = scanner.nextLine();
        System.out.print("Styl nagrobka: ");
        String value8 = scanner.nextLine();
        String value9 = verification.trueFalse("Piwniczka (tak/nie): ");
        System.out.print("Ilość osób: ");
        String value10 = scanner.nextLine();
        String value11 = verification.trueFalse("Liternik (tak/nie): ");
        System.out.print("Imię i nazwisko denata : ");
        String value12 = scanner.nextLine();
        System.out.print("Cena: ");
        String value13 = scanner.nextLine();
        String value14 = verification.openClosed("Status zlecenia (otwarte/zamknięte): ");

        String zapytanie = "INSERT INTO `kamieniarstwo`(`kierownik_prac`, `personalia_klienta`, `do_pogrzebu`, `miejscowosc`, `data_oddania`, `nazwa_kamienia`, `styl_nagrobka`, `piwniczka`, `ilosc_osob`, `liternik`, `imie_nazwisko_denata`, `cena`, `status_zlecenia`) VALUES ('"+value2+"','"+value3+"','"+value4+"','"+value5+"','"+value6+"','"+value7+"','"+value8+"','"+value9+"','"+value10+"','"+value11+"','"+value12+"','"+value13+"','"+value14+"')";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Dodano usługę kamieniarską");
        System.out.println(" ");
    }

    public static void activeOrders(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_zlecenia`,`kierownik_prac`,`personalia_klienta`,`imie_nazwisko_denata`,`data_oddania`,`miejscowosc`,`nazwa_kamienia`,`styl_nagrobka`,`piwniczka`,`ilosc_osob` FROM `kamieniarstwo` WHERE status_zlecenia = 'otwarte'";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_zlecenia");
                String table2 = resultPracownik.getString("kierownik_prac");
                String table3 = resultPracownik.getString("personalia_klienta");
                String table4 = resultPracownik.getString("imie_nazwisko_denata");
                String table5 = resultPracownik.getString("data_oddania");
                String table6 = resultPracownik.getString("miejscowosc");
                String table7 = resultPracownik.getString("nazwa_kamienia");
                String table8 = resultPracownik.getString("styl_nagrobka");
                String table9 = resultPracownik.getString("piwniczka");
                String table10 = resultPracownik.getString("ilosc_osob");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Nr. Zlecenia: " + table1);
                    System.out.println("Kierownik prac: " + table2);
                    System.out.println("Personalia klienta: " + table3);
                    System.out.println("Imię i nazwisko denata: " + table4);
                    System.out.println("Data oddania (rrrr-mm-dd): " + table5);
                    System.out.println("Miejscowość: " + table6);
                    System.out.println("Nazwa kamienia: " + table7);
                    System.out.println("Styl nagrobka: " + table8);
                    System.out.println("Piwniczka: " + table9);
                    System.out.println("Ilość osób: " + table10);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void allOrders(String stanowiskoDB) {
        try {
            String zapytanie = "SELECT `id_zlecenia`,`kierownik_prac`,`personalia_klienta`,`do_pogrzebu`,`miejscowosc`,`data_oddania`,`nazwa_kamienia`,`styl_nagrobka`,`piwniczka`,`ilosc_osob`,`liternik`,`imie_nazwisko_denata`,`cena`,`status_zlecenia` FROM `kamieniarstwo`";
            ResultSet resultPracownik = queryExecutor.executeSelect(zapytanie);

            while (resultPracownik.next()) {

                String table1 = resultPracownik.getString("id_zlecenia");
                String table2 = resultPracownik.getString("kierownik_prac");
                String table3 = resultPracownik.getString("personalia_klienta");
                String table4 = resultPracownik.getString("do_pogrzebu");
                String table5 = resultPracownik.getString("miejscowosc");
                String table6 = resultPracownik.getString("data_oddania");
                String table7 = resultPracownik.getString("nazwa_kamienia");
                String table8 = resultPracownik.getString("styl_nagrobka");
                String table9 = resultPracownik.getString("piwniczka");
                String table10 = resultPracownik.getString("ilosc_osob");
                String table11 = resultPracownik.getString("liternik");
                String table12 = resultPracownik.getString("imie_nazwisko_denata");
                String table13 = resultPracownik.getString("cena");
                String table14 = resultPracownik.getString("status_zlecenia");

                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Nr. Zlecenia: " + table1);
                    System.out.println("Kierownik prac: " + table2);
                    System.out.println("Imie nazwisko klienta: " + table3);
                    System.out.println("Do pogrzebu o id: " + table4);
                    System.out.println("Miejscowość: " + table5);
                    System.out.println("Data oddania (rrrr-mm-dd): " + table6);
                    System.out.println("Nazwa kamienia: " + table7);
                    System.out.println("Styl nagrobka: " + table8);
                    System.out.println("Piwniczka: " + table9);
                    System.out.println("Ilość osób: " + table10);
                    System.out.println("Liternik: " + table11);
                    System.out.println("Imię i nazwisko denata: " + table12);
                    System.out.println("Cena: " + table13);
                    System.out.println("Status zlecenia: " + table14);
                    System.out.println("--");
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeOrder(String stanowiskoDB) {
        activeOrders(stanowiskoDB);

        System.out.print("Podaj Nr. Usługi, która jest do usunięcia: ");
        int stoneID = scanner.nextInt();
        String zapytanie = "DELETE FROM `kamieniarstwo` WHERE id_zlecenia = "+stoneID+"";
        queryExecutor.executeQuery(zapytanie);
    }

    public static void changeStatus(String stanowiskoDB) {
        allOrders(stanowiskoDB);

        System.out.print("Podaj id. zlecenia: ");
        int idZlecenia = scanner.nextInt();
        scanner.nextLine();
        String statusZlecenia = verification.openClosed("Status zlecenia (otwarte/zamknięte): ");

        String zapytanie = "UPDATE `kamieniarstwo` SET `status_zlecenia`='"+statusZlecenia+"' WHERE `id_zlecenia` = '"+idZlecenia+"'";
        queryExecutor.executeQuery(zapytanie);

        System.out.println(" ");
        System.out.println("Zmieniono status zlecenia");
        System.out.println(" ");
    }
}

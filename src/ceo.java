import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
public class ceo {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();

    public static void showResponsibilities(String loginDB, String hasloDB, String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("Dzień dobry "+imieDB+"");
            System.out.println("Dzisiejsza data to: "+ today +"");
            System.out.println("Miłego dnia");
            System.out.println("-----------------------");
            System.out.println("-- Wybierz dział --");
            System.out.println("-----------------------");
            System.out.println("1. Usługi pogrzebowe");
            System.out.println("2. Usługi kamieniarskie");
            System.out.println("3. Zarządzaj pracownikami");
            System.out.println("4. Sprawdź finanse");
            System.out.println("5. Ustawienia");
            System.out.println(" ");
            System.out.println("6. Wyloguj");
            System.out.println(" ");
            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> funeralServices(loginDB, hasloDB, imieDB, stanowiskoDB);
                case 2 -> stoneMasnoryServices(loginDB, hasloDB, imieDB, stanowiskoDB);
                case 3 -> employeeManagement(loginDB, hasloDB, imieDB, stanowiskoDB);
                case 4 -> finance(stanowiskoDB);
                case 5 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ustawienia -");
                    System.out.println("-----------------------");

                    settings.changePassword(loginDB, hasloDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 6 -> {
                    System.out.println("Wylogowywanie...");
                    signIn.logowanie();
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

    }

    public static void funeralServices(String loginDB, String hasloDB ,String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("-- Co chcesz zrobić --");
            System.out.println("-----------------------");
            ceoFuneralServices.numberOfFunerals(stanowiskoDB);
            System.out.println("-----");
            System.out.println("1. Dodaj pogrzeb");
            System.out.println("2. Dodaj obsługę do pogrzebu");
            System.out.println("3. Aktywne zlecenia");
            System.out.println("4. Wszystkie zlecenia");
            System.out.println("5. Usuń pogrzeb");
            System.out.println("6. Usuń obsługę");
            System.out.println("7. Zmień status pogrzebu");
            System.out.println(" ");
            System.out.println("8. Wróć");

            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj pogrzeb -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.addFuneral();

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj obsługę -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.addFuneralDirectors(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Aktywne zlecenia -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.activeOrders(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Wszystkie zlecenia -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.allOrders(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 5 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ususń zlecenie -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.removeOrder(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 6 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ususń Obsługę -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.removeFuneralDirectors(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 7 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Zmień status pogrzebu -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.changeStatus(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 8 -> showResponsibilities(loginDB,hasloDB,imieDB,stanowiskoDB);
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    public static void stoneMasnoryServices(String loginDB, String hasloDB, String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("-- Co chcesz zrobić --");
            System.out.println("-----------------------");
            ceoStoneServices.numberOfOrders(stanowiskoDB);
            System.out.println("-----");
            System.out.println("1. Dodaj zlecenie");
            System.out.println("2. Aktywne zlecenia");
            System.out.println("3. Wszystkie zlecenia");
            System.out.println("4. Usuń zlecenie");
            System.out.println("5. Zmień status zlecenia");
            System.out.println(" ");
            System.out.println("6. Wróć");

            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj zlecenie -");
                    System.out.println("-----------------------");

                    ceoStoneServices.addOrder(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Aktywne zlecenia -");
                    System.out.println("-----------------------");

                    ceoStoneServices.activeOrders(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Wszystkie zlecenia -");
                    System.out.println("-----------------------");

                    ceoStoneServices.allOrders(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ususń zlecenie -");
                    System.out.println("-----------------------");

                    ceoStoneServices.removeOrder(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 5 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Zmień status zlecenia -");
                    System.out.println("-----------------------");

                    ceoStoneServices.changeStatus(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 6 -> showResponsibilities(loginDB, hasloDB, imieDB,stanowiskoDB);
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    public static void employeeManagement(String loginDB, String hasloDB, String imieDB, String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("-- Co chcesz zrobić --");
            System.out.println("-----------------------");
            System.out.println("1. Wyświetl pracowników");
            System.out.println("2. Dodaj Kierownika");
            System.out.println("3. Usuń Kierownika");
            System.out.println("4. Dodaj Pracownika");
            System.out.println("5. Usuń Pracownika");
            System.out.println("6. Zmień rangę");
            System.out.println(" ");
            System.out.println("7. Wróć");

            System.out.print("Wybierz opcje: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Wszyscy pracownicy -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.showEmployees(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj Kierownika -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.addManager();

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Usuń Kierownika -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.removeManager(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj Pracownika -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.addWorker();

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 5 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Usuń Pracownika -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.removeWorker(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }

                case 6 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Zmień rangę -");
                    System.out.println("-----------------------");

                    ceoEmployeeManagement.changeRank(stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 7 -> showResponsibilities(loginDB,hasloDB,imieDB,stanowiskoDB);
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    public static void finance(String stanowiskoDB) {
        System.out.println("-----------------------");
        System.out.println("- Finanse firmy -");
        System.out.println("-----------------------");

        try {
            String zapytaniePogrzeby = "SELECT sum(cena) as laczna_kwota_pogrzeby FROM pogrzeb";
            ResultSet resultPogrzeby = queryExecutor.executeSelect(zapytaniePogrzeby);

            String zapytanieKamieniarstwo = "SELECT sum(cena) as laczna_kwota_kamieniarstwo FROM kamieniarstwo";
            ResultSet resultKamieniarstwo = queryExecutor.executeSelect(zapytanieKamieniarstwo);

            while (resultPogrzeby.next()) {
                String table2 = resultPogrzeby.getString("laczna_kwota_pogrzeby");
                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Zakład pogrzebowy dotychczas wygenerował: " + table2 + "zł.");
                }
            }

            while (resultKamieniarstwo.next()) {
                String table1 = resultKamieniarstwo.getString("laczna_kwota_kamieniarstwo");
                if ("szef".equals(stanowiskoDB)) {
                    System.out.println("Zakład kamieniarski dotychczas wygenerował: " + table1 + "zł.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------------");

        System.out.println("1. Wróć");
        System.out.print("Wybierz opcje: ");
        scanner.nextInt();
    }
}

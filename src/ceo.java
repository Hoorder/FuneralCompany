import java.time.LocalDate;
import java.util.Scanner;
public class ceo {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();

    public static void showResponsibilities(String loginDB, String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("Dzień dobry "+imieDB+"");
            System.out.println("Dzisiejsza data to: "+ today +"");
            System.out.println("Miłego dnia");
            System.out.println("-----------------------");
            System.out.println(" ");
            System.out.println("-- Wybierz dział --");
            System.out.println("1. Usługi pogrzebowe");
            System.out.println("2. Usługi kamieniarskie");
            System.out.println("3. Ustawienia");
            System.out.println();
            System.out.println("4. Wyloguj");
            System.out.println();
            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> funeralServices(loginDB, imieDB, stanowiskoDB);
                case 2 -> stoneMasnoryServices(loginDB, imieDB, stanowiskoDB);
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ustawienia -");
                    System.out.println("-----------------------");

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

    public static void funeralServices(String loginDB, String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("-- Co chcesz zrobić --");
            System.out.println("-----------------------");
            System.out.println("1. Dodaj pogrzeb");
            System.out.println("2. Dodaj obsługę do pogrzebu");
            System.out.println("3. Aktywne zlecenia");
            System.out.println("4. Wszystkie zlecenia");
            System.out.println("5. Usuń zlecenie");
            System.out.println("6. Zarządzaj pracownikami");
            System.out.println(" ");
            System.out.println("7. Wróć");

            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj pogrzeb -");
                    System.out.println("-----------------------");

                    ceoFuneralServices.addFuneral(loginDB,imieDB,stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj obsługę -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Aktywne zlecenia -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Wszystkie zlecenia -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 5 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ususń zlecenie -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 6 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Zarządzaj pracownikami -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 7 -> showResponsibilities(loginDB,imieDB,stanowiskoDB);
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    public static void stoneMasnoryServices(String loginDB, String imieDB,String stanowiskoDB) {

        while (true) {
            System.out.println("-----------------------");
            System.out.println("-- Co chcesz zrobić --");
            System.out.println("-----------------------");
            System.out.println("1. Dodaj zlecenie");
            System.out.println("2. Aktywne zlecenia");
            System.out.println("3. Wszystkie zlecenia");
            System.out.println("4. Usuń zlecenie");
            System.out.println(" ");
            System.out.println("5. Wróć");

            System.out.print("Wybierz opcje: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Dodaj zlecenie -");
                    System.out.println("-----------------------");

                    ceoStoneServices.addOrder(loginDB, imieDB, stanowiskoDB);

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 2 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Aktywne zlecenia -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 3 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Wszystkie zlecenia -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 4 -> {
                    System.out.println("-----------------------");
                    System.out.println("- Ususń zlecenie -");
                    System.out.println("-----------------------");

                    System.out.println("1. Wróć");
                    System.out.print("Wybierz opcje: ");
                    scanner.nextInt();
                }
                case 5 -> showResponsibilities(loginDB,imieDB,stanowiskoDB);
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}

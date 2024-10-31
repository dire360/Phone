import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        char option;

        do {
            System.out.println("\nPhonebook Menu:");
            System.out.println("(a) Add an entry");
            System.out.println("(p) Print the list");
            System.out.println("(e) Edit an entry");
            System.out.println("(d) Delete an entry");
            System.out.println("(s) Sort the list");
            System.out.println("(q) Quit");
            System.out.print("Choose an option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    manager.addEntry(name, address, city, phoneNumber);
                    break;
                case 'p':
                    manager.printList();
                    break;
                case 'e':
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter the name of the entry to edit: ");
                    String editName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new city: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    manager.modifyEntry(editName, newAddress, newCity, newPhoneNumber);
                    break;
                case 'd':
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter the name of the entry to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteEntry(deleteName);
                    break;
                case 's':
                    manager.sortEntries();
                    break;
                case 'q':
                    System.out.println("Exiting phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 'q');

        scanner.close();
    }
}

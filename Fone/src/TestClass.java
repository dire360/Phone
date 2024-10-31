import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        char option;

        // Adding entries
        manager.addEntry("Dylan", "1885 13th street", "Bellingham", "3606713365");
        manager.addEntry("Kennedy", "1845 Greenwood Ave.", "Seattle", "2062245548");
        manager.addEntry("Angela", "5662 Northwest Street", "Bellingham", "3607338965");
        manager.addEntry("Travis", "2432 Senica Street", "Seattle", "2063315632");
        manager.addEntry("Marcel", "1276 Harris Ave.", "Bellingham", "3606717735");

        do {
            System.out.println("\n-Phonebook Menu-");
            System.out.println("(a) Add an entry");
            System.out.println("(p) Print the list");
            System.out.println("(e) Edit an entry");
            System.out.println("(d) Delete an entry");
            System.out.println("(s) Sort the list, a-z");
            System.out.println("(q) Quit");
            System.out.print("Choose an option: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    System.out.println("");
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
                case 'p': // print
                    System.out.println("");
                    manager.printList();
                    break;
                case 'e': // edit
                    System.out.println("");
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
                case 'd': // delete
                    System.out.println("");
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter the name to delete: ");
                    String deleteName = scanner.nextLine();

                    // confirm deletion
                    System.out.print(deleteName + " will be deleted, confirm: (y/n): ");
                    String confirm = scanner.nextLine().toLowerCase();

                    if (confirm.equals("y")) {
                        manager.deleteEntry(deleteName);
                        System.out.println("Deleted...");
                    } else {
                        System.out.println("Canceled");
                    }
                    break;
                case 's': // sort a-z
                    System.out.println("");
                    manager.sortEntries();
                    manager.printList();
                    break;
                case 'q': // quit
                    System.out.println("");
                    System.out.println("Exiting phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 'q');

        scanner.close();
    }
}

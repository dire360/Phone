// Dylan Wilson
// CS 145
// Assignment 2 - PhoneBook

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        // create instance of PhonebookManager called manager, used to call the other classes
        PhonebookManager manager = new PhonebookManager();
        Scanner scanner = new Scanner(System.in);
        char input; // Variable for user input

        // Adding entries to phone book
        manager.addEntry("Dylan", "1885 13th street", "Bellingham", "3606713365");
        manager.addEntry("Kennedy", "1845 Greenwood Ave.", "Seattle", "2062245548");
        manager.addEntry("Angel", "5662 Northwest Street", "Bellingham", "3607338965");
        manager.addEntry("Travis", "2432 Senica Street", "Seattle", "2063315632");
        manager.addEntry("Marcel", "1276 Harris Ave.", "Bellingham", "3606717735");
        // Entries in memory

        do { // Print Phonebook Menu options
            System.out.println("\n-Phonebook Menu-");
            System.out.println("(a) Add an entry");
            System.out.println("(p) Print the list");
            System.out.println("(e) Edit an entry");
            System.out.println("(d) Delete an entry");
            System.out.println("(s) Sort the list, a-z");
            System.out.println("(q) Quit");
            System.out.print("Choose an option: ");
            input = scanner.next().charAt(0);

            // switch/case to handle user input

            switch (input) {
                case 'a': // add 
                    System.out.println("");
                    scanner.nextLine();  // Consume newline
                    // Collect user info to add new contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    // add entry method. contact added to the phonebook
                    manager.addEntry(name, address, city, phoneNumber);
                    break;

                case 'p': // print
                    System.out.println("");
                    // Prints all contacts in phone book
                    manager.printList();
                    break;

                case 'e': // edit
                    System.out.println("");
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter name to edit attributes: ");
                    String editName = scanner.nextLine();

                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();

                    System.out.print("Enter new city: ");
                    String newCity = scanner.nextLine();
                   
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();  

                    // modify entry method will modify a contacts info
                    manager.modifyEntry(editName, newAddress, newCity, newPhoneNumber);
                    break;

                case 'd': // delete
                    System.out.println("");
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter the name to delete: ");
                    // Prompt user for name to delete 
                    String deleteName = scanner.nextLine();

                    // Confirm deletion with y/n if/else 
                    System.out.print(deleteName + " will be deleted, confirm: (y/n): ");
                    String confirm = scanner.nextLine().toLowerCase();
                    // if user enters a Y or y contact is deleted
                    if (confirm.equals("y")) {
                        manager.deleteEntry(deleteName);
                        System.out.println("Deleted...");
                    } else { // Or else cancel and break
                        System.out.println("Canceled");
                    }
                    break;

                case 's': // sort a-z
                    System.out.println("");
                    // call sortEntries method then print the sorted list
                    manager.sortEntries();
                    manager.printList();
                    break;

                case 'q': // quit
                    System.out.println("");
                    System.out.println("Exiting phonebook. Goodbye!");
                    break;

                default: // if no cases are meet continue loop
                    System.out.println("Invalid option. Please try again.");
            }
        } while (input != 'q'); // if not "q" continue loop

        scanner.close();
    }
}

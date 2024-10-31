import java.util.Scanner; // Import Scanner class

public class PhonebookManager {
    private PhonebookNode head;
    private Scanner scanner = new Scanner(System.in);

    public PhonebookManager() {
        this.head = null;
    }

    // Add an entry to the end of the list
    public void addEntry(String name, String address, String city, String phoneNumber) {
        String validatedPhoneNumber = validatePhoneNumber(phoneNumber); // Validate the phone number
        PhonebookNode newNode = new PhonebookNode(name, address, city, validatedPhoneNumber);
        
        if (head == null) {
            head = newNode;
        } else {
            PhonebookNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    

    // Sort the list alphabetically by name
    public void sortEntries() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            PhonebookNode current = head;
            PhonebookNode prev = null;
            PhonebookNode next = head.next;
            swapped = false;
            while (next != null) {
                if (current.name.compareTo(next.name) > 0) {
                    swapped = true;
                    if (prev != null) {
                        PhonebookNode temp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        PhonebookNode temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }
                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }

    // Modify an entry
    public void modifyEntry(String name, String newAddress, String newCity, String newPhoneNumber) {
        PhonebookNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                temp.address = newAddress;
                temp.city = newCity;
                temp.phoneNumber = newPhoneNumber;
                break;
            }
            temp = temp.next;
        }
    }

    // Delete an entry
    public void deleteEntry(String name) {
        if (head == null) return;

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        PhonebookNode temp = head;
        while (temp.next != null) {
            if (temp.next.name.equals(name)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Print the list
    public void printList() {
        PhonebookNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    private String validatePhoneNumber(String phoneNumber) {
        while (!phoneNumber.matches("\\d{10}")) { // Check if input has exactly 10 digits
            System.out.println("Invalid phone number. Please enter a 10-digit phone number:");
            
            phoneNumber = scanner.nextLine(); // Prompt user for input again if invalid
        }
        return phoneNumber;
    }
    
}

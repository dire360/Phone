// Dylan Wilson
// CS 145
// Assignment 2 - PhoneBook

import java.util.Scanner; // Import Scanner class

public class PhonebookManager {
    // set to head node of linked list; begining of list
    private PhonebookNode head;
    private Scanner scanner = new Scanner(System.in);
 
    public PhonebookManager() {
        // constructor for initialization
        this.head = null; // head = null means empty list
    }

    // Add an entry to the end of the list
    public void addEntry(String name, String address, String city, String phoneNumber) {
        // validate phone number
        String validatedPhoneNumber = validatePhoneNumber(phoneNumber);
        // Create a new Phone book Node with listed atributes
        PhonebookNode newNode = new PhonebookNode(name, address, city, validatedPhoneNumber);
        
        if (head == null) { // if empty
            head = newNode; // set new Node as head (1st in list)
        } else { // or else
            PhonebookNode temp = head; // temp node is used to iterate list
            while (temp.next != null) { // while temp node is not = 0 
                temp = temp.next; // iterate to next node
            }
            temp.next = newNode; // add the new Node to end of linked list
        }
    }

    // Sort the list alphabetically by name
    public void sortEntries() {
        // if list is empty or only 1 node return. nothing to sort
        if (head == null || head.next == null) return;
        // swapped flag, if false no swaps made
        boolean swapped;
        do { // do/while loop
            PhonebookNode current = head; // head of list
            PhonebookNode prev = null; // node before current
            PhonebookNode next = head.next; // node after current
            swapped = false; // reset to false after each iteration
            while (next != null) { // until next = null
                if (current.name.compareTo(next.name) > 0) { // if value > 0 
                    swapped = true; // boolean swapped is true
                    if (prev != null) { // if prev is not null 
                        PhonebookNode temp = next.next; // temp for storing next.next
                        prev.next = next; // swap
                        next.next = current; // swap
                        current.next = temp; // swap complete
                    } else { // or else do not swap
                        PhonebookNode temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }
                    prev = next; // set prev to next
                    next = current.next; // set next to current
                } else { // or else advamce 1 node
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped); // while true loop
    }

    // Modify entry
    public void modifyEntry(String name, String newAddress, String newCity, String newPhoneNumber) {
        // start from the head of list with temp
        PhonebookNode temp = head;
    
        while (temp != null) { // while not at end of list
            if (temp.name.equals(name)) { // check if name = name in node
                // update node attributes
                temp.address = newAddress;
                temp.city = newCity;
                temp.phoneNumber = newPhoneNumber;
                break;
            }
            temp = temp.next; // advance to next node
        }
    }

    // Delete an entry
    public void deleteEntry(String name) {
        // of list is empty nothing to delete, return
        if (head == null) return;

        if (head.name.equals(name)) { // check if node contains the name to delete
            head = head.next; // move head node to next node
            return;
        }
        
        // start from the head of list with temp
        // temp is a reference point, an instance of PhonebookNode.
        PhonebookNode temp = head;

        while (temp.next != null) { // check linked list
            if (temp.next.name.equals(name)) { // if next nodes name equals name to delete
                temp.next = temp.next.next; // connect with the next next in the list
                return;
            }
            temp = temp.next; // move to next node in list
        }
    }

    // Print the list
    public void printList() {
        // start from the head of list with temp
        PhonebookNode temp = head;
        while (temp != null) { // while the list is not empty
            System.out.println(temp); // print the current node
            temp = temp.next; // advance 1 node
        }
    }
    
    // validate phone number method checks for 10 digits and reprompts if needed
    private String validatePhoneNumber(String phoneNumber) {
        while (!phoneNumber.matches("\\d{10}")) { // Check if input has exactly 10 digits
            System.out.println("Invalid phone number. Please enter a 10-digit phone number:");           
            phoneNumber = scanner.nextLine(); // Prompt user for input again if invalid
        }
        return phoneNumber; // return phone number when valid
    }
}

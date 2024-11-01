// Dylan Wilson
// CS 145
// Assignment 2 - PhoneBook

public class PhonebookNode {
    // variables set up to store contact info
    String name;
    String address;
    String city;
    String phoneNumber;
    PhonebookNode next;  // Reference to the next node in the linked list
    
    // constructor to initialize format for node
    public PhonebookNode(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null; // initialize next with value null
    }

    // This method will format the 10 digit # like "(206) 222-2222"
    private String formatPhoneNumber(String phoneNumber) {
        return String.format("(%s) %s-%s", // format the numbers with substrings
            phoneNumber.substring(0, 3), // 1,2,3
            phoneNumber.substring(3, 6), // 4,5,6
            phoneNumber.substring(6, 10)); // 7,8,9,10
    }
     // Override toString method to return a string with formated phone number
    @Override
    public String toString() {
        return name + " - " + address + ", " + city + " - " + formatPhoneNumber(phoneNumber);
    }
}

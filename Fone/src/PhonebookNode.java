// Dylan Wilson
// CS 145
// Assignment 2 - PhoneBook

public class PhonebookNode {
    String name;
    String address;
    String city;
    String phoneNumber;
    PhonebookNode next;

    public PhonebookNode(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    private String formatPhoneNumber(String phoneNumber) {
        return String.format("(%s) %s-%s", 
            phoneNumber.substring(0, 3), 
            phoneNumber.substring(3, 6), 
            phoneNumber.substring(6, 10));
    }

    @Override
    public String toString() {
        return name + " - " + address + ", " + city + " - " + formatPhoneNumber(phoneNumber);
    }
}

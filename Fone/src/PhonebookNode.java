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

    @Override
    public String toString() {
        return name + " - " + address + ", " + city + " - " + phoneNumber;
    }
}

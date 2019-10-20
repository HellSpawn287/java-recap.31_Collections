package arraylist.mobilephone_contact_app;

public class Contact {
    private String name;
    private int phoneNumber;

    public Contact(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public static arraylist.mobilephone_contact_app.Contact createContact(String name, int phoneNumber){
        return new arraylist.mobilephone_contact_app.Contact(name, phoneNumber);
    }

    @Override
    public String toString() {
        return name + '\'' +
                " --> " + phoneNumber ;
    }
}

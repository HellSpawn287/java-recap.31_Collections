package arraylist.mobilephone_contact_app;

import java.util.Scanner;

class MyMobilePhoneClient {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Mobilephone mobilephone = new Mobilephone("0048256256256");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action number: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down....");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContacts();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void queryContacts() {
        Contact existingRecord = enterContactNameAndSearch();
        if (existingRecord == null) return;

        System.out.println("Contact name: " + existingRecord.getName() +
                " phone number is: " + existingRecord.getPhoneNumber());
    }

    private static Contact enterContactNameAndSearch() {
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingRecord = mobilephone.queryContacts(name);
        if (existingRecord == null) {
            System.out.println("Contact not found.");
            return null;
        }
        return existingRecord;
    }

    private static void removeContact() {
        Contact existingRecord = enterContactNameAndSearch();
        if (existingRecord == null) return;

        if (mobilephone.removeContact(existingRecord)) {
            System.out.println("Successfully removed record");
        } else {
            System.out.println("Error removing record");
        }
    }

    private static void updateContact() {
        Contact existingRecord = enterContactNameAndSearch();
        if (existingRecord == null) return;

        System.out.println("Enter new contact name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number:");
        int number = scanner.nextInt();
        Contact newContact = Contact.createContact(newName, number);
        if (mobilephone.updateContact(existingRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter new contact number:");
        int number = scanner.nextInt();
        Contact contact = Contact.createContact(name, number);
        if (mobilephone.addNewContact(contact)) {
            System.out.println(
                    "New contact added: name = " + name +
                            ", phone = " + number);
        } else {
            System.out.println("Cannot add, " + name + " already on file.");
        }
    }

    private static void printContacts() {
        System.out.println("Contact list: ");
        mobilephone.printContacts();
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: " +
                "\npress:" +
                "0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - to query if searching contact exist\n" +
                "6 - to print a list of available actions\n");
        System.out.println("Choose your action: ");
    }

    private static void startPhone() {
        System.out.println("Starting phone... ");
    }


}

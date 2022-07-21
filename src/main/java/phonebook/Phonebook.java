package phonebook;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Phonebook {

    private Scanner scanner
            = new Scanner(System.in);

    private final List<Contact> contacts;

    public Phonebook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String addContact() {
        System.out.println("Enter contact's name: ");
        String contactName = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter contact's email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(contactName, phoneNumber, email);
        this.contacts.add(contact);
        return contact + " added successfully!";
    }

    public void removeContact() {
        System.out.println("Enter contact's index: ");
        int index = scanner.nextInt();
        removeContact(index);
    }

    public void removeContact(int index) {
        this.contacts.remove(index);
        System.out.println("Removed contact with index " + index);
    }

    public void findContact() {
        System.out.println("Please enter the name of contact you want to find: ");
        String name = scanner.nextLine();
        Contact contact = findContactByName(name);

        if (contact != null) {
            System.out.println("Contact details: " + contact);
        } else {
            System.out.println("Contact with name = " + name + " wasn't found!");
        }
    }

    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (Objects.equals(contact.name, name)) {
                return contact;
            }
        }

        return null;
    }

    public void listContacts() {
        int i = 0;
        for (Contact contact : contacts) {
            System.out.println(i++ + ". " + contact);
        }
    }

    public void menu() {
        while (true) {
            System.out.println("What do you want to do?: ");
            System.out.println("1. Add new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Remove contact");
            System.out.println("4. Find contact");
            System.out.println("5. Exit");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println(this.addContact());
                    break;
                case 2:
                    this.listContacts();
                    break;
                case 3:
                    this.removeContact();
                    break;
                case 4:
                    this.findContact();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }
}


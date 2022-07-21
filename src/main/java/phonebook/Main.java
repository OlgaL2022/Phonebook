package phonebook;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final PersistenceService persistenceService = new PersistenceService();
        final List<Contact> contacts = persistenceService.loadContacts();
        final Phonebook phonebook = new Phonebook(contacts);
        phonebook.menu();
        persistenceService.saveContacts(contacts);

    }
}



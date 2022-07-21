package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService {
    public static final String CONTACT_FILE = "phonebook.txt";

    public void saveContacts(List<Contact> contacts) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(CONTACT_FILE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(contacts);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> loadContacts() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(CONTACT_FILE))) {
            return (List<Contact>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

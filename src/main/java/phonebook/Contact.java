package phonebook;

import java.io.Serializable;

public class Contact implements Serializable {

    public String name;
    public String phoneNumber;
    public String email;

    public Contact(String name, String phoneNumber, String email) {
       this.name = name;
       this.phoneNumber = phoneNumber;
       this.email = email;
   }

    @Override public String toString() {
        return "Contact with " +
                "name: " + name  +
                ", phone number: " + phoneNumber +
                ", email: " + email;
    }
}




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class Contact {
    private String name;
    private String phoneNumber;
    private String surname;
    public Contact(String name, String surname, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public  String getSurname(){
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {
    private Contact contact;
    private String message;
    public Message(Contact contact, String message) {
        this.contact = contact;
        this.message = message;
    }

    public Contact getContact() {
        return contact;
    }

    public String getMessage() {
        return message;
    }
}


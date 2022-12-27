import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone {
    private int hours;
    private String color;
    private String material;
    private Map<String, Contact> contacts;
    private List<Message> messages;
    private List<Call> calls;
    private String brand;
    private  String model;

    public Phone(int hours, String color, String material, String brand, String model) {
        this.hours = hours;
        this.color = color;
        this.material = material;
        this.brand = brand;
        this.model = model;
        this.contacts = new HashMap<>();
        this.messages = new ArrayList<>();
        this.calls = new ArrayList<>();
    }

    public void createContact(String name, String surname, String phoneNumber) {
        Contact contact = new Contact(name,surname, phoneNumber);
        contacts.put(phoneNumber, contact);
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }

    public void sendMessage(String phoneNumber, String message) {
        if (message.length() > 500) {
            throw new IllegalArgumentException("Message cannot be more than 500 characters");
        }
        if (hours == 0) {
            throw new IllegalStateException("Phone is out of battery");
        }
        Contact contact = contacts.get(phoneNumber);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        Message msg = new Message(contact, message);
        messages.add(msg);
        hours--;
    }

    public List<Message> getMessages(String phoneNumber) {
        Contact contact = contacts.get(phoneNumber);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        List<Message> contactMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getContact().getPhoneNumber().equals(phoneNumber)) {
                contactMessages.add(message);
            }
        }
        return contactMessages;
    }

    public void makeCall(String phoneNumber) {
        if (hours < 2) {
            throw new IllegalStateException("Phone cannot make a call");
        }
        Contact contact = contacts.get(phoneNumber);
        if (contact == null) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        Call call = new Call(contact);
        calls.add(call);
        hours -= 2;
    }
    public List<Call> getCallHistory() {
        return new ArrayList<>(calls);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "hours=" + hours +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", contacts=" + contacts +
                ", messages=" + messages +
                ", calls=" + calls +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}


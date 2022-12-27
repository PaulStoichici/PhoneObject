
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Phone phone = new Phone(10, "black", "plastic","Samsung","Galaxy S6");
        phone.createContact("Alice", "Black", "0987654321");
        phone.createContact("Bob", "Bober", "1234567890");
        phone.sendMessage("1234567890", "Hello, Bobby!");
        phone.sendMessage("0987654321", "Buna ziua Alice! Sper ca merge bine telefonul");
        phone.makeCall("0987654321");
        List<Message> aliceMessages = phone.getMessages("0987654321");
        List<Message> bobMessages = phone.getMessages("1234567890");
        List<Call> callHistory = phone.getCallHistory();
        for (Call call : callHistory)
        {
            Contact contact = call.getContact();
            String name = contact.getName();
            String surname = contact.getSurname();
            String phoneNumber = contact.getPhoneNumber();
            System.out.println("You have called " + name + " "+ surname +" " + phoneNumber + " ");
        }
        for (Message message : aliceMessages) {
            System.out.println("Message to " + message.getContact().getName() + " " + message.getContact().getSurname() +": " + message.getMessage());
        }
        for (Message message : bobMessages) {
            System.out.println("Message to " + message.getContact().getName() + " " + message.getContact().getSurname() + ": " + message.getMessage());
        }
        System.out.println("Phone information:");
        System.out.println("hours left on phone battery: " +phone.getHours());
        System.out.println("Model: "+ phone.getModel());
        System.out.println("Brand: "+ phone.getBrand());
        System.out.println("Culoare: "+ phone.getColor());
        System.out.println("Material: "+ phone.getMaterial());

    }
}
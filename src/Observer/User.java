package Observer;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String email;
    public List<String> emailMessages = new ArrayList<String>();

    public User(String email) {
        this.email = email;
    }

    public void receiveMessage(String message) {
        emailMessages.add(message);
    }

    public String getLastEmail() {
        if (emailMessages.isEmpty())
            return null;
        else {
            return emailMessages.getLast();
        }
    }
}

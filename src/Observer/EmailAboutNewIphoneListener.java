package Observer;

import java.util.ArrayList;
import java.util.List;

class EmailAboutNewIphoneListener implements EventListener {
    List<User> subscribers = new ArrayList<User>();

    public void subscribeMe(User user) {
        subscribers.add(user);
    }

    public void update(String iphoneVersion) {
        subscribers.forEach(subscriber -> {
            System.out.println("Sending email to " + subscriber.email + " about " + iphoneVersion);
            subscriber.receiveMessage("The new Iphone " + iphoneVersion + " is finally released!");
        });
    }
}

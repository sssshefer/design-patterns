package Observer;

public class Main {
    public static void main(String[] args) {
        // Create the publisher (subject)
        IphonePublisher iphonePublisher = new IphonePublisher();

        // Create an email alert listener (subscriber)
        EmailAboutNewIphoneListener EmailAboutNewIphoneListener = new EmailAboutNewIphoneListener();

        User user1 = new User("user1@example.com");
        User user2 = new User("user2@example.com");

        // Subscribe some users to the email alert listener
        EmailAboutNewIphoneListener.subscribeMe(user1);

        // Subscribe the listener to the "newIphone" event in the publisher
        iphonePublisher.events.subscribe("newIphone", EmailAboutNewIphoneListener);

        System.out.println("user1 mails before iPhone release: " + user1.getLastEmail());
        System.out.println("user2 mails before iPhone release: " + user2.getLastEmail() +"\n");

        System.out.println("iPhone 15 Pro is released!\n");
        // Simulate the release of a new iPhone
        iphonePublisher.releaseNewIphone("iPhone 15 Pro");

        System.out.println("\nuser1 mails after iPhone 15 Pro release: " + user1.getLastEmail());
        System.out.println("user2 mails after iPhone 15 Pro release: " + user2.getLastEmail());


        // Unsubscribe emailAlertListener from the event
        iphonePublisher.events.unsubscribe("newIphone", EmailAboutNewIphoneListener);
        System.out.println("\nUnsubscribing notifications from new releases");

        // Simulate another iPhone release, which should not trigger notifications
        iphonePublisher.releaseNewIphone("iPhone 16");

        System.out.println("user1 mails after iPhone 16 release: " + user1.getLastEmail());
        System.out.println("user2 mails after iPhone 16 release: " + user2.getLastEmail());
    }
}
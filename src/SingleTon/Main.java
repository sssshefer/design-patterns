package SingleTon;

public class Main {
    public static void main(String[] args) {
        LoginManager loginManager = LoginManager.getInstance();

        loginManager.login("user", "wrongpassword");
        System.out.println("Is user logged in? " + loginManager.isLoggedIn());

        loginManager.login("admin", "password");
        System.out.println("Is user logged in? " + loginManager.isLoggedIn());
        System.out.println("Logged-in user: " + loginManager.getLoggedInUser());

        loginManager.logout();
        System.out.println("Is user logged in? " + loginManager.isLoggedIn());
        System.out.println("Logged-in user: " + loginManager.getLoggedInUser());
    }
}

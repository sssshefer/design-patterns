package SingleTon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LoginManager {
    private static LoginManager instance;

    private LoginManager(){};

    public static LoginManager getInstance(){
       if(instance == null){
           instance = new LoginManager();
       }
       return instance;
    }

    private String loggedInUser;

    public void login(String username, String password){
        if(username.equals("admin") && password.equals("password")){
            loggedInUser = username;
            System.out.println("Successful login!");
        }else{
            System.out.println("Failed to login! Invalid credentials");
        }
    }

    public void logout(){
        if(isLoggedIn()){
            System.out.println("There is not logged in user");
        }else{
            loggedInUser = null;
            System.out.println("Logged out successfully!");
        }
    }

    public Boolean isLoggedIn(){
        return(loggedInUser != null);
    }

    public String getLoggedInUser(){
        return loggedInUser;
    }


}
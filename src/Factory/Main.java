package Factory;

public class Main {
    static String currentEnv;
    static Dialog dialog;

    public static void main(String[] args) {
        currentEnv = "Windows";

        switch (currentEnv){
            case "Windows":
                dialog = new WindowsDialog();
                break;
            case "Web":
                dialog = new WebDialog();
                break;
            default:
                System.out.println("Unknown environment");
        }

        dialog.createButton().onClick();
    }
}

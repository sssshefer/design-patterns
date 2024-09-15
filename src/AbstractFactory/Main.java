package AbstractFactory;

import Factory.Dialog;
import Factory.WebDialog;
import Factory.WindowsDialog;

public class Main {
    static String currentEnv;
    static GUIFactory factory;

    public static void main(String[] args) {
        currentEnv = "Win";

        switch (currentEnv){
            case "Win":
                factory = new WinFactory();
                break;
            case "Mac":
                factory = new MacFactory();
                break;
            default:
                System.out.println("Unknown OS");
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.click();
        checkbox.check();
    }
}

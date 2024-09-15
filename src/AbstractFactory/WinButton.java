package AbstractFactory;

public class WinButton implements Button{
    @Override
    public void click() {
        System.out.println("WinButton is clicked!");
    }
}

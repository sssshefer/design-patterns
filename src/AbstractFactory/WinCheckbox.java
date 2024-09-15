package AbstractFactory;

public class WinCheckbox implements Checkbox{
    @Override
    public void check() {
        System.out.println("WinCheckbox is checked");
    }
}

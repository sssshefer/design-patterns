package AbstractFactory;

public class MacCheckbox implements Checkbox{
    @Override
    public void check() {
        System.out.println("MacCheckbox is checked");
    }
}

package Factory;

abstract public class Dialog {

    public abstract Button createButton();

    public void render (){
        Button okButton = createButton();
        // some business logic
        okButton.onClick();
    }
}

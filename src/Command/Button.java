package Command;

public class Button {
    Runnable onClick;
    String styles;

    public void setCommand(Runnable command) {
        this.onClick = command;
    }

    Button( String styles){
        this.styles = styles;
    }

    public void click() {
        if (onClick != null) {
            onClick.run();
        }
    }
}

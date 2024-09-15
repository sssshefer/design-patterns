package Command;

public class Editor {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelection() {
        System.out.println("Receiving information about selected text");
        return "Test selected text";
    }

    public void deleteSelection() {
       System.out.println("Selected text is deleted");
    }

    public void replaceSelection(String text) {
        System.out.println("Selection is replaced with this text");
    }
}
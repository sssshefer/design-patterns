package Command;

public class Main {
    public static void main(String[] args) {
        // Initialize the application and editor
        Application app = new Application();
        Editor editor = new Editor();

        // Set initial text in the editor
        editor.setText("Hello, this is a sample text.");


        System.out.println("Initial Text: " + editor.getText());

        // Test CopyCommand (does not change editor state)
        Command copyCommand = new CopyCommand(app, editor);
        app.executeCommand(copyCommand);
        System.out.println("Clipboard after Copy: " + app.getClipboard());

        Command cutCommand = new CutCommand(app, editor);
        app.executeCommand(cutCommand);

        Command pasteCommand = new PasteCommand(app, editor);
        app.executeCommand(pasteCommand);

        app.undo();
        app.undo();
    }
}


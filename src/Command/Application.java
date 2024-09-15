package Command;

public class Application {
    private String clipboard;
    private Editor activeEditor;
    private CommandHistory history = new CommandHistory();

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public void createUI() {
        Button copyButton = new Button("CopyButton styles");
        copyButton.setCommand(() -> executeCommand(new CopyCommand(this, activeEditor)));

        Button cutButton = new Button("CutButton styles");
        cutButton.setCommand(() -> executeCommand(new CutCommand(this, activeEditor)));

        Button pasteButton = new Button("PasteButton styles");
        pasteButton.setCommand(() -> executeCommand(new PasteCommand(this, activeEditor)));

        Button undoButton = new Button("UndoButton styles");
        undoButton.setCommand(() -> executeCommand(new UndoCommand(this, activeEditor)));
    }
}

package Command;

abstract public class Command {
    Application app;
    Editor editor;
    String backup;

    Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    protected void saveBackup() {
        backup = editor.getText();
    }

    public void undo() {
        editor.setText(backup);
    }

    public abstract Boolean execute();
}

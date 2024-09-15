package Command;

public class CopyCommand extends Command {
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public Boolean execute() {
        app.setClipboard(editor.getSelection());
        return false;
    }
}

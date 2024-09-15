package Command;

public class CutCommand extends Command {
    public CutCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public Boolean execute() {
        saveBackup();
        editor.deleteSelection();
        return true;
    }
}

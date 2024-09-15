package Command;

public class PasteCommand extends Command{
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public Boolean execute() {
        saveBackup();
        editor.replaceSelection(app.getClipboard());
        return true;
    }
}

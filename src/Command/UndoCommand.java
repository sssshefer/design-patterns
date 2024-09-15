package Command;

public class UndoCommand extends Command {
    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public Boolean execute() {
        app.undo();
        return false;
    }
}

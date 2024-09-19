package RPG.Actions;

import RPG.GameCharacter.GameCharacter;

public class IncreaseDefense extends Action {
    public IncreaseDefense(GameCharacter gameCharacter) {
        super(gameCharacter);
    }

    @Override
    public boolean execute() {
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() + 3);
        return true;
    }
}

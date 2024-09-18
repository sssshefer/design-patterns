package RPG.Actions;

import RPG.GameCharacter.GameCharacter;

//Command pattern
abstract public class Action {
    GameCharacter gameCharacter;

    public Action(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }

    public abstract boolean execute();
}

package RPG.CombatStrategies;

import RPG.GameCharacter.GameCharacter;

public interface CombatStrategy {
    void executeStrategy(GameCharacter gameCharacter);
}

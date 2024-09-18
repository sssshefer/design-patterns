package RPG.Duel;

import RPG.CombatStrategies.BalancedStrategy;
import RPG.CombatStrategies.CombatStrategy;
import RPG.GameCharacter.GameCharacter;

//Bridge
public class DuelCharacter {
    GameCharacter gameCharacter;
    CombatStrategy combatStrategy;

    DuelCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        this.combatStrategy = new BalancedStrategy();
    }

    public boolean isAlive() {
        return this.gameCharacter.getHealth() > 0;
    }
}

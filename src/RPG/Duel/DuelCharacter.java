package RPG.Duel;

import RPG.CombatStrategies.BalancedStrategy;
import RPG.CombatStrategies.CombatStrategy;
import RPG.GameCharacter.GameCharacter;

//Bridge
public class DuelCharacter {
    GameCharacter gameCharacter;
    CombatStrategy combatStrategy;

    public DuelCharacter(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
        this.combatStrategy = new BalancedStrategy();
        this.combatStrategy.executeStrategy(this.gameCharacter);
    }

    public GameCharacter getGameCharacter() {
        return gameCharacter;
    }

    public boolean isAlive() {
        return this.gameCharacter.getHealth() > 0;
    }

    public void setCombatStrategy(CombatStrategy combatStrategy) {
        this.combatStrategy.deselectStrategy(gameCharacter);
        combatStrategy.executeStrategy(gameCharacter);
        this.combatStrategy = combatStrategy;
    }
}

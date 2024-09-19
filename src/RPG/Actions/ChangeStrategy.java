package RPG.Actions;

import RPG.CombatStrategies.CombatStrategy;
import RPG.Duel.DuelCharacter;
import RPG.GameCharacter.GameCharacter;


public class ChangeStrategy extends Action {
    CombatStrategy strategy;
    DuelCharacter duelCharacter;
    public ChangeStrategy(DuelCharacter duelCharacter, CombatStrategy newStrategy) {
        super(duelCharacter.getGameCharacter());
        this.duelCharacter = duelCharacter;
        this.strategy = newStrategy;
    }

    @Override
    public boolean execute() {
        duelCharacter.setCombatStrategy(strategy);
        return true;
    }
}

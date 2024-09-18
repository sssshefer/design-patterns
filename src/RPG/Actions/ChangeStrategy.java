package RPG.Actions;

import RPG.CombatStrategies.CombatStrategy;
import RPG.GameCharacter.GameCharacter;


public class ChangeStrategy extends Action{
    CombatStrategy strategy;

    public ChangeStrategy(GameCharacter gameCharacter, CombatStrategy strategy) {
        super(gameCharacter);
        this.strategy = strategy;
    }

    @Override
    public boolean execute() {
//        if(gameCharacter.getStrategy() == strategy)
//            return false;
//       gameCharacter.setStrategy(strategy);
//       return true;
        return true;
    }
}

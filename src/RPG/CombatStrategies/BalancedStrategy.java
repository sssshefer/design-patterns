package RPG.CombatStrategies;

import RPG.GameCharacter.GameCharacter;

public class BalancedStrategy implements CombatStrategy{
    @Override
    public void executeStrategy(GameCharacter gameCharacter) {
        gameCharacter.setBaseDamage(gameCharacter.getBaseDamage() * 3);
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() * 3);
        System.out.println("Balanced Strategy: normal damage, normal defense.");
    }
}

package RPG.CombatStrategies;

import RPG.GameCharacter.GameCharacter;

public class AggressiveStrategy implements CombatStrategy {
    @Override
    public void executeStrategy(GameCharacter gameCharacter) {
        gameCharacter.setBaseDamage(gameCharacter.getBaseDamage() * 4);
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() * 2);
        System.out.println("Aggressive Strategy: High damage, low defense.");
    }

    @Override
    public void deselectStrategy(GameCharacter gameCharacter){
        gameCharacter.setBaseDamage(gameCharacter.getBaseDamage() / 4);
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() / 2);
        System.out.println("Aggressive Strategy is no longer active");
    }
}

package RPG.CombatStrategies;

import RPG.GameCharacter.GameCharacter;

public class DefensiveStrategy implements CombatStrategy{
    @Override
    public void executeStrategy(GameCharacter gameCharacter) {
        gameCharacter.setBaseDamage(gameCharacter.getBaseDamage() * 2);
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() * 4);
        System.out.println("Defensive Strategy: low damage, high defense.");
    }

    @Override
    public void deselectStrategy(GameCharacter gameCharacter){
        gameCharacter.setBaseDamage(gameCharacter.getBaseDamage() / 2);
        gameCharacter.setBaseDefense(gameCharacter.getBaseDefense() / 4);
        System.out.println("Defensive Strategy is no longer active");
    }
}

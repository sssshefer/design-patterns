package RPG.Actions;

import RPG.GameCharacter.GameCharacter;
import RPG.Weapons.Weapon;

public class Attack extends Action {
    GameCharacter target;

    public Attack(GameCharacter gameCharacter, GameCharacter target) {
        super(gameCharacter);
        this.target = target;
    }

    @Override
    public boolean execute() {
        Weapon equippedWeapon = gameCharacter.getEquippedWeapon();
        int coreCharacterSkill = gameCharacter.getCoreCharacterSkill();
        int baseWeaponDamage;
        int fitWeaponMultiplication;
        if (equippedWeapon != null) {
            GameCharacter bestFitFor = equippedWeapon.getBestFitFor();
            baseWeaponDamage = equippedWeapon.getBaseDamage();
            boolean isWeaponFitCharacter = gameCharacter.equals(bestFitFor);
            fitWeaponMultiplication = isWeaponFitCharacter ? 2 : 1;
        } else {
            baseWeaponDamage = 1;
            fitWeaponMultiplication = 1;
        }

        int finalDamage = (fitWeaponMultiplication * coreCharacterSkill) + baseWeaponDamage + gameCharacter.getBaseDamage();

        System.out.println(gameCharacter.getName() + "Damage " + finalDamage + " hp");
        int receivedDamage = target.receiveDamage(finalDamage);
        System.out.println(target.getName() + " base defense is " + target.getBaseDefense());
        System.out.println(target.getName() + "Receives " + receivedDamage + " hp");

        gameCharacter.setExp(gameCharacter.getExp() + finalDamage);
        return true;
    }
}

package RPG.Weapons;

import RPG.GameCharacter.Warrior;

public class Sword extends Weapon{
    public Sword(String name, int baseDamage){
        super(name, baseDamage, new Warrior());
    }
}

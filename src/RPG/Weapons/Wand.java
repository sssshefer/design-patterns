package RPG.Weapons;

import RPG.GameCharacter.Mage;

public class Wand extends Weapon{

    public Wand(String name, int baseDamage){
        super(name, baseDamage, new Mage());
    }

}

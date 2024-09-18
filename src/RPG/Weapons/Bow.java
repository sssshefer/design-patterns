package RPG.Weapons;

import RPG.GameCharacter.Archer;
import RPG.GameCharacter.GameCharacter;

public class Bow extends Weapon{
    Bow(String name, int baseDamage){
        super(name, baseDamage, new Archer());
    }
}

package RPG.Weapons;

import RPG.GameCharacter.Archer;

public class Bow extends Weapon {
    public Bow(String name, int baseDamage) {
        super(name, baseDamage, new Archer());
    }
}

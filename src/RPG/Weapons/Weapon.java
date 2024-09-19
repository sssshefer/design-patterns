package RPG.Weapons;

import RPG.GameCharacter.GameCharacter;
import RPG.Item;

import java.util.ArrayList;
import java.util.Random;

abstract public class Weapon extends Item {
    private int baseDamage;
    private GameCharacter bestFitFor;

    Weapon(String name, int baseDamage, GameCharacter bestFitFor) {
        super(name);
        this.baseDamage = baseDamage;
        this.bestFitFor = bestFitFor;
    }


    public int getBaseDamage() {
        return baseDamage;
    }

    // Getter for best-fit character
    public GameCharacter getBestFitFor() {
        return bestFitFor;
    }


}

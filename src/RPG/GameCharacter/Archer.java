package RPG.GameCharacter;

public class Archer extends GameCharacter {
    public Archer() {
        health += 20;
        mana += 20;
        dexterity += 1;
    }

    public Archer(String username) {
        super(username);
        health += 8;
        mana += 7;
        dexterity += 1;
    }

    @Override
    public void lvlUpSkills(int lvls) {
        this.power += lvls;
        this.dexterity += 2 * lvl;
        this.intelligence += lvls;
    }
}

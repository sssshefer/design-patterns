package RPG.GameCharacter;

public class Mage extends GameCharacter {
    public Mage() {
        mana += 30;
        health += 20;
        intelligence += 1;
    }

    public Mage(String username) {
        super(username);
        mana += 10;
        health += 5;
        intelligence += 1;
    }

    @Override
    public void lvlUpSkills(int lvls) {
        this.power += lvls;
        this.dexterity += lvls;
        this.intelligence += lvls * 2;
    }
}

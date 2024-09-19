package RPG.GameCharacter;

public class Warrior extends GameCharacter {
    public Warrior() {
        health += 30;
        mana += 10;
        power += 1;
    }

    public Warrior(String username){
        super(username);
        health += 10;
        mana += 5;
        power += 1;
    }
    @Override
    public void lvlUpSkills(int lvls) {
        this.power += 2 * lvls;
        this.dexterity += lvl;
        this.intelligence += lvls;
    }
}

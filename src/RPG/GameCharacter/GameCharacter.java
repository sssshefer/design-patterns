package RPG.GameCharacter;

import RPG.Actions.Action;
import RPG.CombatStrategies.BalancedStrategy;
import RPG.CombatStrategies.CombatStrategy;
import RPG.Inventory;
import RPG.Weapons.Weapon;
import RPG.World.TimeOfDay;
import RPG.World.WorldListener;

import java.sql.Time;

abstract public class GameCharacter implements WorldListener {
    String name;

    Inventory inventory;
    Weapon equippedWeapon;

    int health;
    int mana;

    int power;
    int dexterity;
    int intelligence;

    int exp;
    int lvl;
    int baseDamage;
    int baseDefense;


    GameCharacter() {
        this.health = 100;
        this.mana = 100;

        this.power = 1;
        this.dexterity = 1;
        this.intelligence = 1;

        this.inventory = new Inventory();
        this.exp = 0;
        this.lvl = 1;
        this.baseDamage = 7;
        this.baseDefense = 2;
    }

    GameCharacter(String name) {
        this.name = name;

        this.health = 100;
        this.mana = 100;

        this.power = 1;
        this.dexterity = 1;
        this.intelligence = 1;

        this.inventory = new Inventory();
        this.exp = 0;
        this.lvl = 1;
        this.baseDamage = 7;
        this.baseDefense = 2;

    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int value) {
        this.exp = value;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }


    public int getCoreCharacterSkill() {
        return Math.max(Math.max(power, dexterity), intelligence);
    }

    public boolean lvlUp() {
        if (exp > 100) {
            int lvls = exp / 100;

            lvlUpSkills(lvls);
            setLvl(lvls);
            setExp(getExp() % 100);

            System.out.println("You level is increased by " + lvls);
            return true;
        }
        return false;
    }

    //Command pattern
    public void executeAction(Action action) {
        if (action.execute()) {

        }

    }

    public int getLvl() {
        return lvl;
    }

    public int receiveDamage(int damage) {
        int finalDamage = Math.max(damage - baseDefense, 0);
        setHealth(health - finalDamage);
        return finalDamage;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void onWorldEvent(TimeOfDay timeOfDay) {
        adjustStatsBasedOnTime(timeOfDay);

    }

    private void adjustStatsBasedOnTime(TimeOfDay timeOfDay) {
        if (timeOfDay == TimeOfDay.DAY) {
            setBaseDamage(getBaseDamage() + 5);
            System.out.println("All players received +" + 5 + " damage because of the day time ");
        } else {
            setBaseDamage(getBaseDamage() - 5);
            System.out.println("All players damage was reduced by  " + 5 + " because of the night time");
        }
    }


    protected abstract void lvlUpSkills(int lvls);

}

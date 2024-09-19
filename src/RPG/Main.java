package RPG;

import RPG.Actions.Action;
import RPG.Actions.EquipWeapon;
import RPG.Duel.Duel;
import RPG.GameCharacter.Archer;
import RPG.GameCharacter.GameCharacter;
import RPG.GameCharacter.Mage;
import RPG.GameCharacter.Warrior;
import RPG.Weapons.Bow;
import RPG.Weapons.Sword;
import RPG.Weapons.Wand;
import RPG.Weapons.Weapon;
import RPG.World.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        //Singleton pattern
        World world = World.getInstance();

        Player player1 = createPlayer(1);
        Player player2 = createPlayer(2);

        GameCharacter gameCharacter1 = createGameCharacter(player1.getUsername());
        GameCharacter gameCharacter2 = createGameCharacter(player2.getUsername());

        world.addGameCharacter(gameCharacter1);
        world.addGameCharacter(gameCharacter2);

        offerSearchForWeapon(gameCharacter1);
        offerSearchForWeapon(gameCharacter2);

        Duel duel = new Duel(gameCharacter1, gameCharacter2, world);
        duel.start();

    }

    private static Player createPlayer(int playerNumber) {
        System.out.println("Choose username for player" + playerNumber + ":");
        String username = in.nextLine();
        return new Player(username);
    }

    private static GameCharacter createGameCharacter(String username) {
        GameCharacter gameCharacter = null;

        while (gameCharacter == null) {
            System.out.println(username + ", choose character class: (Type 'warrior', 'archer', or 'mage')");
            String characterClassName = in.nextLine().toLowerCase();

            //Factory pattern
            switch (characterClassName) {
                case "warrior":
                    gameCharacter = new Warrior(username);
                    break;
                case "mage":
                    gameCharacter = new Mage(username);
                    break;
                case "archer":
                    gameCharacter = new Archer(username);
                    break;
                default:
                    System.out.println("Unknown character class");
            }
        }
        return gameCharacter;
    }

    private static Weapon offerWeaponChose() {
        String[] magicWeaponNames = {
                "Stardust",
                "Moonshadow",
                "Earthsong",
                "Grieving Glaive",
                "Sharpened Heart",
                "Relentless Vessel",
                "Nightmare",
                "Sapience"};

        System.out.println("You move forward and find three weapons in a chest: \n");

        Weapon sword = new Sword(magicWeaponNames[rand.nextInt(8)] + " sword", rand.nextInt(10) + 1);
        Weapon bow = new Bow(magicWeaponNames[rand.nextInt(8)] + " bow", rand.nextInt(10) + 1);
        Weapon wand = new Wand(magicWeaponNames[rand.nextInt(8)] + " wand", rand.nextInt(10) + 1);

        System.out.println("You spotted " + sword.getName() + ". Damage: " + sword.getBaseDamage() + ". Best fit for Warrior");
        System.out.println("You spotted " + bow.getName() + ". Damage: " + bow.getBaseDamage() + ". Best fit for Archer");
        System.out.println("You spotted " + wand.getName() + ". Damage: " + wand.getBaseDamage() + ". Best fit for Mage");
        System.out.println("\nWhich one would you like to pick? (Type 'sword', 'bow', or 'wand')");

        Weapon chosenWeapon = null;
        boolean validChoice = false;

        while (!validChoice) {
            String weaponChoice = in.nextLine().toLowerCase();

            switch (weaponChoice) {
                case "sword":
                    chosenWeapon = sword;
                    validChoice = true;
                    break;
                case "bow":
                    chosenWeapon = bow;
                    validChoice = true;
                    break;
                case "wand":
                    chosenWeapon = wand;
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please type 'sword', 'bow', or 'wand'.");
                    break;
            }
        }
        System.out.println("You have chosen the " + chosenWeapon.getName() + " with a base damage of " + chosenWeapon.getBaseDamage() + ".");
        return chosenWeapon;
    }

    private static void offerSearchForWeapon(GameCharacter gameCharacter){
        System.out.println("\n"+gameCharacter.getName() + ", would you like to search for a weapon? (yes/no)");
        String response = in.nextLine().toLowerCase();

        if (response.equals("yes")) {
            System.out.println("You decide to search for a weapon.");
            Weapon chosenWeapon = offerWeaponChose();

            // Equip the chosen weapon to the game character
            gameCharacter.getInventory().addItem(chosenWeapon);
            Action equip = new EquipWeapon(gameCharacter, chosenWeapon);
            equip.execute();
            System.out.println(gameCharacter.getName() + " is now equipped with " + chosenWeapon.getName() + "!");
        } else if (response.equals("no")) {
            System.out.println(gameCharacter.getName() + " decides not to search for a weapon.");
        } else {
            System.out.println("Invalid choice. Please type 'yes' or 'no'.");
            offerSearchForWeapon(gameCharacter); // Recursively ask again for valid input
        }
    }
}

package RPG;

import RPG.Duel.Duel;
import RPG.GameCharacter.Archer;
import RPG.GameCharacter.GameCharacter;
import RPG.GameCharacter.Mage;
import RPG.GameCharacter.Warrior;
import RPG.World.World;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        //Singleton pattern
        World world = World.getInstance();

        Player player1 = createPlayer(1);
        Player player2 = createPlayer(2);

        GameCharacter gameCharacter1 = createGameCharacter(player1.getUsername());
        GameCharacter gameCharacter2 = createGameCharacter(player2.getUsername());

        world.addGameCharacter(gameCharacter1);
        world.addGameCharacter(gameCharacter2);

//        System.out.println(gameCharacter1.getBaseDamage());
//        System.out.println(gameCharacter2.getBaseDamage());
//        world.skipTime();
//        System.out.println(gameCharacter1.getBaseDamage());
//        System.out.println(gameCharacter2.getBaseDamage());
//        world.skipTime();
//        System.out.println(gameCharacter1.getBaseDamage());
//        System.out.println(gameCharacter2.getBaseDamage());

        Duel duel = new Duel(gameCharacter1, gameCharacter2);
        duel.start();
//        playableCharacter.executeAction(new Attack(playableCharacter));
//        playableCharacter.executeAction(new Attack(playableCharacter));
//        playableCharacter.executeAction(new Attack(playableCharacter));
    }

    private static Player createPlayer(int playerNumber) {
        System.out.println("Choose username for player" + playerNumber + ":");
        String username = in.nextLine();
        return new Player(username);
    }

    private static GameCharacter createGameCharacter(String username) {
        GameCharacter gameCharacter = null;

        while (gameCharacter == null) {
            System.out.println(username + ", choose character class:");
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
}

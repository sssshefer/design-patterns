package RPG.Duel;

import RPG.Actions.Action;
import RPG.Actions.Attack;
import RPG.Actions.ChangeStrategy;
import RPG.Actions.IncreaseDefense;
import RPG.CombatStrategies.AggressiveStrategy;
import RPG.CombatStrategies.BalancedStrategy;
import RPG.CombatStrategies.CombatStrategy;
import RPG.CombatStrategies.DefensiveStrategy;
import RPG.GameCharacter.GameCharacter;
import RPG.Weapons.Weapon;
import RPG.World.World;

import java.util.Scanner;

public class Duel {
    DuelCharacter player1;
    DuelCharacter player2;
    private boolean player1Turn;
    private Scanner in = new Scanner(System.in);
    private World world;

    public Duel(GameCharacter character1, GameCharacter character2, World world) {
        this.player1 = new DuelCharacter(character1);
        this.player2 = new DuelCharacter(character2);
        this.world = world;
        this.player1Turn = true;
    }

    public void start() {
        System.out.println("\nThe duel between " + player1.gameCharacter.getName() + " and " + player2.gameCharacter.getName() + " begins!\n");
        int counter = 0;
        while (player1.isAlive() && player2.isAlive()) {
            counter++;
            if (counter % 3 == 0) {
                world.skipTime();
            }
            DuelCharacter currentPlayer = player1Turn ? player1 : player2;
            DuelCharacter opponent = player1Turn ? player2 : player1;

            System.out.println(player1.gameCharacter.getName() + " HP: " + player1.gameCharacter.getHealth());
            System.out.println(player1.gameCharacter.getName() + " Damage: " + player1.gameCharacter.getBaseDamage());
            System.out.println(player1.gameCharacter.getName() + " Defense: " + player1.gameCharacter.getBaseDefense());
            Weapon equippedWeapon1 = player1.gameCharacter.getEquippedWeapon();
            if (equippedWeapon1 != null)
                System.out.println(player1.gameCharacter.getName() + " Weapon: " + equippedWeapon1.getName() + ", damage:" + equippedWeapon1.getBaseDamage() + "\n");

            System.out.println(player2.gameCharacter.getName() + " HP: " + player2.gameCharacter.getHealth());
            System.out.println(player2.gameCharacter.getName() + " Damage: " + player2.gameCharacter.getBaseDamage());
            System.out.println(player2.gameCharacter.getName() + " Defense: " + player2.gameCharacter.getBaseDefense());
            System.out.println(player2.gameCharacter.getName() + " Defense: " + player2.gameCharacter.getBaseDefense());
            Weapon equippedWeapon2 = player2.gameCharacter.getEquippedWeapon();
            if (equippedWeapon2 != null)
                System.out.println(player2.gameCharacter.getName() + " Weapon: " + equippedWeapon2.getName() + ", damage:" + equippedWeapon2.getBaseDamage() + "\n");

            System.out.println(currentPlayer.gameCharacter.getName() + "'s turn:");
            Action action = getPlayerAction(currentPlayer, opponent);
            action.execute();

            // Switch turns
            player1Turn = !player1Turn;

            // Display health status after each round
            System.out.println(player1.gameCharacter.getName() + " HP: " + player1.gameCharacter.getHealth());
            System.out.println(player2.gameCharacter.getName() + " HP: " + player2.gameCharacter.getHealth());
            System.out.println("--------------------------------------");
        }

        // Determine winner
        if (player1.isAlive()) {
            System.out.println(player1.gameCharacter.getName() + " wins!");
        } else {
            System.out.println(player2.gameCharacter.getName() + " wins!");
        }
    }

    private Action getPlayerAction(DuelCharacter currentPlayer, DuelCharacter opponent) {
        System.out.println("Choose your action: (1) Attack (2) Defend (3) Change Strategy");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                return new Attack(currentPlayer.gameCharacter, opponent.gameCharacter);
            case 2:
                return new IncreaseDefense(currentPlayer.gameCharacter);
            case 3:
                CombatStrategy newStrategy = offerChangeStrategy(currentPlayer);
                return new ChangeStrategy(currentPlayer, newStrategy);
            default:
                System.out.println("Invalid choice, defaulting to Attack");
                return new Attack(currentPlayer.gameCharacter, opponent.gameCharacter);
        }
    }

    private CombatStrategy offerChangeStrategy(DuelCharacter duelCharacter) {
        System.out.println(duelCharacter.gameCharacter.getName() + ", would you like to change your combat strategy? (attack/defend/balanced)");

        // Get player's input
        String strategyChoice = in.nextLine().toLowerCase();

        CombatStrategy newStrategy = null;

        // Switch based on input to set the appropriate strategy
        switch (strategyChoice) {
            case "attack":
                newStrategy = new AggressiveStrategy(); // Assuming AttackStrategy is a concrete class implementing Action
                System.out.println(duelCharacter.gameCharacter.getName() + " has chosen an aggressive attack strategy.");
                break;
            case "defend":
                newStrategy = new DefensiveStrategy(); // Assuming DefendStrategy is a concrete class implementing Action
                System.out.println(duelCharacter.gameCharacter.getName() + " has chosen a defensive strategy.");
                break;
            case "balanced":
                newStrategy = new BalancedStrategy(); // Assuming DefendStrategy is a concrete class implementing Action
                System.out.println(duelCharacter.gameCharacter.getName() + " has chosen a balanced strategy.");
                break;
            default:
                System.out.println("Invalid choice. Please choose either 'attack', 'defend' or 'balanced'");
                return offerChangeStrategy(duelCharacter); // Recursively ask for valid input
        }

        // Set the chosen strategy for the game character
        return newStrategy;

    }


}

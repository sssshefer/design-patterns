package RPG.Duel;

import RPG.Actions.Action;
import RPG.Actions.Attack;
import RPG.Actions.IncreaseDefense;
import RPG.GameCharacter.GameCharacter;

import java.util.Scanner;

public class Duel {
    DuelCharacter player1;
    DuelCharacter player2;
    private boolean player1Turn;
    private Scanner in = new Scanner(System.in);

    public Duel(GameCharacter character1, GameCharacter character2){
        this.player1 = new DuelCharacter(character1);
        this.player2 = new DuelCharacter(character2);
        this.player1Turn = true;
    }

    public void start() {
        System.out.println("The duel between " + player1.gameCharacter.getName() + " and " + player2.gameCharacter.getName() + " begins!");

        while (player1.isAlive() && player2.isAlive()) {
            DuelCharacter currentPlayer = player1Turn ? player1 : player2;
            DuelCharacter opponent = player1Turn ? player2 : player1;

            System.out.println(player1.gameCharacter.getName() + " HP: " + player1.gameCharacter.getHealth());
            System.out.println(player2.gameCharacter.getName() + " HP: " + player2.gameCharacter.getHealth());

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
        System.out.println("Choose your action: (1) Attack (2) Defend");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                return new Attack(currentPlayer.gameCharacter, opponent.gameCharacter);
            case 2:
                return new IncreaseDefense(currentPlayer.gameCharacter);
            default:
                System.out.println("Invalid choice, defaulting to Attack");
                return new Attack(currentPlayer.gameCharacter, opponent.gameCharacter);
        }
    }

}

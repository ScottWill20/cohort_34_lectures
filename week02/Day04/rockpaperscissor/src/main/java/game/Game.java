package game;

import game.players.Computer;
import game.players.Player;
import game.players.Human;
import game.players.PlayerHelper.*;

// this is the line importing all the fields from the PlayerHelper
import static game.players.PlayerHelper.*;

public class Game {

    // build out a play method

    public void play() {
        System.out.printf("Welcome to %s | %s | %s |%n", ROCK_ICON, PAPER_ICON, SCISSOR_ICON);
        System.out.println();

        // create our players
        Player human = new Human();
        Player computer = new Computer();

        // prompt the human for their move
        String humanMove = human.generateMove();
        System.out.println();
        System.out.println("Good luck...");
        System.out.println();

        // randomly generate the computer move
        String computerMove = computer.generateMove();

        System.out.println(determineWinner(humanMove,computerMove));
    }

    // build out the determine winner method
    public String determineWinner(String humanMove, String computerMove) {
        if (computerMove.equalsIgnoreCase(humanMove)) {
            return String.format("You both picked %s - it's a tie!", humanMove);
        } else if ((computerMove.equalsIgnoreCase(ROCK) && humanMove.equalsIgnoreCase(PAPER)) ||
                (computerMove.equalsIgnoreCase(PAPER) && humanMove.equalsIgnoreCase(SCISSORS)) ||
                (computerMove.equalsIgnoreCase(SCISSORS) && humanMove.equalsIgnoreCase(ROCK))) {
            return String.format("The computer picked %s and you picked %s - You Win! 🥳",computerMove, humanMove);
        } else {
            return String.format("The computer picked %s and you picked %s - You Lose 😭", computerMove, humanMove);
        }
    }
}

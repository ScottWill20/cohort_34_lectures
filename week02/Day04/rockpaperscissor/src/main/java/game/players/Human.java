package game.players;

import java.util.Scanner;

public class Human implements Player {


    @Override
    public String generateMove(){
        Scanner console = new Scanner(System.in);
        System.out.println("Please select your move: ");
        System.out.printf("1. %s%n", PlayerHelper.ROCK);
        System.out.printf("2. %s%n", PlayerHelper.PAPER);
        System.out.printf("3. %s%n", PlayerHelper.SCISSORS);

        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("Make your move");
            choice = Integer.parseInt(console.nextLine());
            if (choice < 1 || choice > 3) {
                System.out.println("That's not a valid move - please choose between 1 and 3");
            }
        }
        return PlayerHelper.getPlayerMove(choice);
    }


}

package game.players;

import java.util.Random;

public class Computer implements Player {


    @Override
    public String generateMove() {
        Random random = new Random();
        int choice = random.nextInt(3) + 1; // This will return a number between 1 and 3 // bound 3 will return 0 - 2 + 1
        return PlayerHelper.getPlayerMove(choice);
    }
}

package game.players;

public class PlayerHelper {
    // icons

    public static final String ROCK_ICON = "🪨";
    public static final String PAPER_ICON = "📃";
    public static final String SCISSOR_ICON = "✂";

    // moves

    public static final String ROCK = "rock: " + ROCK_ICON;
    public static final String PAPER = "paper: " + PAPER_ICON;
    public static final String SCISSORS = "scissors: " + SCISSOR_ICON;

    //method - that gets a players move

    public static String getPlayerMove(int choice) {
        String move = null;
        switch(choice){
            case 1:
                move = ROCK;
                break;
            case 2:
                move = PAPER;
                break;
            case 3:
                move = SCISSORS;
                break;
        }
        return move;
    }


}

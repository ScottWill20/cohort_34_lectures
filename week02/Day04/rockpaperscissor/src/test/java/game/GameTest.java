package game;

import org.junit.jupiter.api.Test;
import static game.players.PlayerHelper.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test
    void rockShouldBeatScissors() {
        String result = game.determineWinner(ROCK, SCISSORS);
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you picked %s - You Win! 🥳",SCISSORS, ROCK), result);
    }

    @Test
    void scissorsShouldLoseToRock() {
        String result = game.determineWinner(SCISSORS, ROCK);
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you picked %s - You Lose 😭", ROCK, SCISSORS),result);
    }

    // etc.....

}
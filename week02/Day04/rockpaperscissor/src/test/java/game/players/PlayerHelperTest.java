package game.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerHelperTest {

    @Test
    void choiceOneShouldGenerateRock() {
        String result = PlayerHelper.getPlayerMove(1);
        assertNotNull(result);
        assertEquals(PlayerHelper.ROCK, result);
    }
    @Test
    void choiceTwoShouldGeneratePaper() {
        String result = PlayerHelper.getPlayerMove(2);
        assertNotNull(result);
        assertEquals(PlayerHelper.PAPER, result);
    }
    @Test
    void choiceThreeShouldGenerateScissors() {
        String result = PlayerHelper.getPlayerMove(3);
        assertNotNull(result);
        assertEquals(PlayerHelper.SCISSORS, result);
    }
}
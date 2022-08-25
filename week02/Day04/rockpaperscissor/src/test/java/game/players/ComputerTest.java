package game.players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer;

    @BeforeEach
    // arrange
    void setup() {
        computer = new Computer();
    }
    @Test
    void generateMoveShouldGenerateRandomMove() {
        // act
        for (int i = 0; i < 10000; i++) {
            String result = computer.generateMove();
            // assert
            assertTrue(result.equals(PlayerHelper.ROCK) ||
                    result.equals(PlayerHelper.PAPER) ||
                    result.equals(PlayerHelper.SCISSORS));
        }
    }
}
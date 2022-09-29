package learn.shell_game.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class ConceptController {

    private static int jokerCard = 0;

    @PostMapping("/start")
    public String pickCard()
    {
        jokerCard = 0;
        jokerCard = getValue();
        return "Pick a card! 1, 2, or 3?";
    }

    @PostMapping("/replay")
    public String replay()
    {
        return "Would you like to play again?";
    }

    @PutMapping("/{choice}")
    public String checkChoice(@PathVariable int choice)
    {
        if (choice == jokerCard)
        {
            return "You found the Joker!";
        }
        return "You lose!";
    }

    private static int getValue()
    {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
}

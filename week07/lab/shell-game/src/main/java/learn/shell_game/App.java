package learn.shell_game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

    /*
     * Find a card hidden among three cards or an object hidden under a cup.
     * No need to represent actual cards or cups. Generate a random number between 1 and 3.
     * If the user guesses the correct number, they win. If not, they lose. Make it fancier once
     * it's working: keep track of a score, give hints, etc.
     */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}



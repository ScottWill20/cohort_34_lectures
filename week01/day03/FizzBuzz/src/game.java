import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        // Variables
        Scanner console = new Scanner(System.in);
        boolean validChoice = false;
        String userChoice = "";

        do {
            System.out.print("Please select your move: (rock, paper, scissors): ");
            userChoice = console.nextLine();

            if (userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper") || userChoice.equalsIgnoreCase("scissors")) {
                // if its a valid choice
                validChoice = true; // switching this to true so that the loop stops running if the choice is valid
            } else {
                System.out.print("That is not a valid choice, please choose rock, paper, or scissors");
            }

        } while (!validChoice); // while validChoice is false, loop will keep running

        // generate computer choice randomly
        int random = (int)Math.floor(Math.random() * 3); // we need to explicitly cast this to an integer because random returns a double
        String compChoice = null; // I do not have a value

        switch (random) {
            case 0:
                compChoice = "rock";
                break;
            case 1:
                compChoice = "paper";
                break;
            case 2:
                compChoice = "scissors";
                break;
        }

        // Loading message
        String graphic = "LOADING";
        // loop through the string, print out one letter at a time
        for (int i = 0; i < graphic.length(); i++) {
            System.out.println(graphic.charAt(i));
        }

        // compare choices to determine winner
        if (compChoice.equalsIgnoreCase(userChoice)) {
            System.out.printf("You both picked %s - it's a tie!", userChoice);
        } else if (compChoice.equals("rock") && userChoice.equalsIgnoreCase("paper")) {
            System.out.printf("The computer picked %s amd you picked %s - you win!", compChoice, userChoice);
        } else if (compChoice.equals("paper") && userChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("The computer picked %s amd you picked %s - you win!", compChoice, userChoice);
        } else if (compChoice.equals("scissors") && userChoice.equalsIgnoreCase("rock")) {
            System.out.printf("The computer picked %s amd you picked %s - you win!", compChoice, userChoice);
        } else {
            System.out.printf("The computer picked %s and you picked %s - you lose :(", compChoice, userChoice);
        }

    }
}

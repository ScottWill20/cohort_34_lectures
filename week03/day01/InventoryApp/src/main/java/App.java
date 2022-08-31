import application.helper.Controller;
import application.helper.InsufficientInventoryException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InsufficientInventoryException {
        Scanner console = new Scanner(System.in);
        Controller controller = new Controller();
        controller.run(console);

    }
}

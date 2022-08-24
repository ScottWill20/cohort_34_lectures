import inventory.Flavors;
import stores.CookiePopUp;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static ArrayList<Flavors> flavors = new ArrayList<>();
    static CookiePopUp cookiePopUp = new CookiePopUp("Cookies Galore", flavors);

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Cookies Galore!");

        boolean exit = false;

        do {
            int choice = menu(console);
            switch(choice){
                case 1:
                    cookiePopUp.addInventory(console, flavors);
                    break;
                case 2:
                    cookiePopUp.updateInventory(console, cookiePopUp.grabIndex(console, cookiePopUp.inventory), cookiePopUp.inventory);
                    break;
                case 3:
                    cookiePopUp.viewInventory(cookiePopUp.inventory);
                    break;
                case 4:
                    System.out.println("Are you sure you want to exit?");
                    System.out.println("All data will be lost.");
                    String option = console.nextLine();
                    if (option.equalsIgnoreCase("yes")) {
                        exit = true;
                    } else {
                        exit = false;
                    }
                    break;
                default:
                    System.out.println("That is not an option. Please choose 1 - 4.");
            }

        } while(!exit);

    } // closes main

    public static int menu(Scanner console){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("*".repeat(10));
        System.out.println("1. Add Inventory");
        System.out.println("2. Update Inventory");
        System.out.println("3. View Inventory");
        System.out.println("4. Exit");
        System.out.println();
        System.out.println("What would you like to do? [1-4]: ");

        int menuOption = Integer.parseInt(console.nextLine());
        return menuOption;


    }

} // closes class

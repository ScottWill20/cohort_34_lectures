package application.helper;

import application.inventory.Flavors;
import application.stores.CookiePopUp;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ArrayList<Flavors> flavours = new ArrayList<>();
    CookiePopUp cookieShop = new CookiePopUp("Marthas pop up", flavours);

    public void run(Scanner console) throws InsufficientInventoryException {
        System.out.println("Welcome to the Inventory App");
        System.out.println();
        boolean exit = false;

        do{
            int choice = menu(console);
            switch(choice){
                case 1:
                    cookieShop.addInventory(console, flavours);
                    ReadWriteHelper.writeToFile("data/inventory.txt", cookieShop.getInventory());
                    break;
                case 2:
                    cookieShop.updateInventory(console, cookieShop.grabIndex(console, cookieShop.inventory), cookieShop.inventory);
                    ReadWriteHelper.writeToFile("data/inventory.txt", cookieShop.getInventory());
                    break;
                case 3:
                    cookieShop.viewInventory(cookieShop.inventory);
                    System.out.println(ReadWriteHelper.readFromFile("data/inventory.txt"));
                    break;
                case 4:
                    System.out.println("Are you sure you want to exit?");
                    System.out.println("[yes / no]: ");
                    console.nextLine();
                    String option = console.nextLine();
                    if(option.equalsIgnoreCase("yes")){
                        exit = true;
                    }else{
                        exit = false;
                    }
            }
        }while(!exit);
    }

    public int menu(Scanner console){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1. Add Inventory");
        System.out.println("2. Update Inventory");
        System.out.println("3. View Inventory");
        System.out.println("4. Exit");
        System.out.print("What would you like to do? ");
        int menuOption = Integer.parseInt(console.nextLine());
        return menuOption;
    }
}

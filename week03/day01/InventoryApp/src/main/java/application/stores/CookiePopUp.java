package application.stores;

import application.helper.InsufficientInventoryException;
import application.inventory.CookieFlavor;
import application.inventory.Flavors;

import java.util.ArrayList;
import java.util.Scanner;

public class CookiePopUp implements Store {

    // fields
    private String name;
    public ArrayList<Flavors> inventory;

    public CookiePopUp(String name, ArrayList<Flavors> inventory) {
        this.name = name;
        this.inventory = inventory;
    }
    public CookiePopUp(){

    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flavors> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Flavors> inventory) {
        this.inventory = inventory;
    }

    @Override
    public ArrayList<Flavors> addInventory(Scanner console, ArrayList<Flavors> array) throws InsufficientInventoryException {
        Flavors flavor = new Flavors();
        System.out.println("What flavor would you like to add?: ");
        flavor.setFlavorName(setType(console));

        System.out.println("How many do you have?: ");
        flavor.setCount(Integer.parseInt(console.nextLine()));
        if(flavor.getCount() <= 0){
            throw new InsufficientInventoryException();
            // this technique is called defensive programming - we are immediately getting an error rather than allowing our program to store that value which could cause an error in the future
        }
        array.add(flavor);

        return array;
    }

    @Override
    public void viewInventory(ArrayList<Flavors> flavors) {
        for(Flavors f : flavors ){
            System.out.println(f);
        }
    }

    @Override
    public int grabIndex(Scanner console, ArrayList<Flavors> array) {
        int index = -1; // if we set this to 0 and we don't find any flavor we are going to get back the first flavor in array
        System.out.println("What flavor would you like to update? ");
        CookieFlavor update = setType(console);
        for(Flavors f : array){
            if(update.getDisplayText().equalsIgnoreCase(f.getFlavorName().getDisplayText())){
                index = array.indexOf(f);
            }
        }
        return index;
    }

    @Override
    public void updateInventory(Scanner console, int x, ArrayList<Flavors> array) throws InsufficientInventoryException {
        // creating a new flavor
        Flavors flavor = new Flavors();
        // grab the current flavor at that index and keep the name the same
        flavor.setFlavorName(array.get(x).getFlavorName());
        // ask the user to update the count
        System.out.println("How many do you have now? ");
        flavor.setCount(Integer.parseInt(console.nextLine()));
        // if the count is less than 0 - we want to throw an exception
        if(flavor.getCount() < 0){
            throw new InsufficientInventoryException();
        }
        array.set(x, flavor);
    }


    // TODO build out a method to set cookie flavor types based on enum values
    public CookieFlavor setType(Scanner console){
        System.out.println("1. " + CookieFlavor.PEANUTBUTTER.getDisplayText());
        System.out.println("2. " + CookieFlavor.CHOCOLATE_CHIP.getDisplayText());
        System.out.println("3. " + CookieFlavor.SNICKERDOODLE.getDisplayText());
        System.out.println("4. " + CookieFlavor.WHITE_CHOCLATE.getDisplayText());
        System.out.println("5. " + CookieFlavor.OATMEAL_RASIN.getDisplayText());

        int choice = Integer.parseInt(console.nextLine());

        CookieFlavor flavorName = null;
        switch(choice){
            case 1:
                flavorName = CookieFlavor.PEANUTBUTTER;
                break;
            case 2:
                flavorName = CookieFlavor.CHOCOLATE_CHIP;
                break;
            case 3:
                flavorName = CookieFlavor.SNICKERDOODLE;
                break;
            case 4:
                flavorName = CookieFlavor.WHITE_CHOCLATE;
                break;
            case 5:
                flavorName = CookieFlavor.OATMEAL_RASIN;
                break;
            default:
                System.out.println("Sorry, that flavor is not an option please choose [1-5]");
                setType(console); // call the method to prompt the user to choose again.
                break;
        }
        return flavorName;
    }


}

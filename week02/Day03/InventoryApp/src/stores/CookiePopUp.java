package stores;

import inventory.Flavors;

import java.util.ArrayList;
import java.util.Scanner;

public class CookiePopUp implements StoreInterface {
    //fields
    private String name;
    public ArrayList<Flavors> inventory;


    // constructors

    public CookiePopUp(String name, ArrayList<Flavors> inventory) {
        this.name = name;
        this.inventory = inventory;
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

    // Methods - this is where we implement the "how"

    @Override
    public ArrayList<Flavors> addInventory(Scanner console, ArrayList<Flavors> array) {
        Flavors flavor = new Flavors();
        System.out.println("What flavor would you like to add?: ");
        flavor.setItemName(console.nextLine());
        System.out.println("How many do you have?: ");
        flavor.setCount(Integer.parseInt(console.nextLine()));

        array.add(flavor);

        return array;
    }

    @Override
    public void viewInventory(ArrayList<Flavors> flavors) {
        for (Object flavor : flavors){
            System.out.println(flavor);
        }

    }

    @Override
    public int grabIndex(Scanner console, ArrayList<Flavors> array) {
        int index = -1;
        System.out.println("What flavor would you like to update?: ");
        String update = console.nextLine();
        // looping through all items in the array
        for (Flavors flavor : array){
            // checking to see if the current index matches the flavor from the user
            if (flavor.getItemName().equalsIgnoreCase(update)) {
                // if it does - we grab the index number
                index = array.indexOf(flavor);
            }
        }
        // return the index number
        return index;
    }

    @Override
    public void updateInventory(Scanner console, int x, ArrayList<Flavors> array) {
        // creating a new flavor
        Flavors flavor = new Flavors();
        // grabbing the current flavor at that index and keeping the name the same
        flavor.setItemName(array.get(x).getItemName());
        // asking user to update the count
        System.out.println("How many do you have now?: ");
        // updating the count
        flavor.setCount(Integer.parseInt(console.nextLine()));
        // setting the new flavor with the same name and updated count into the array
        array.set(x,flavor);
    }
}

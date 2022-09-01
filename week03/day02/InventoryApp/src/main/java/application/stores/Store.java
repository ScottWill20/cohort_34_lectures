package application.stores;

import application.helper.InsufficientInventoryException;
import application.inventory.Flavors;

import java.util.ArrayList;
import java.util.Scanner;

public interface Store {
    // add
    ArrayList<Flavors> addInventory(Scanner console, ArrayList<Flavors> array) throws InsufficientInventoryException;
    // view
    void viewInventory(ArrayList<Flavors> flavors);
    // application.helper method
    int grabIndex(Scanner console, ArrayList<Flavors> array);
    // update
    void updateInventory(Scanner console, int x, ArrayList<Flavors> array) throws InsufficientInventoryException;
}

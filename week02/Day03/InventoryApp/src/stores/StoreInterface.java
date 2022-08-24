package stores;

import inventory.Flavors;
import java.util.ArrayList;
import java.util.Scanner;

// Rules for when to use an interface
// 1. when there are two or more concrete implementations that solve one problem
// 2. when there are two or more concrete implementations that solve one problem BUT there's a possibility of different implementations.
// 3. to control test - what we will use them for mostly in this course

public interface StoreInterface {

    // this is the "what" - we do not include details about the "how" - that happens in a class
    // add
    ArrayList<Flavors> addInventory(Scanner console, ArrayList<Flavors> array);

    // view
    void viewInventory(ArrayList<Flavors> flavors);

    // helper method
    int grabIndex(Scanner console, ArrayList<Flavors> array);

    //update
    void updateInventory(Scanner console, int x, ArrayList<Flavors> array);


}

package learn;

import learn.collections.CityAnimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class App {
    public static void main(String[] args) {
/*
        // HashMaps
        // HashMap<unique identifier, object> = nameOfMap = new HashMap<unique identifier, object>();
        HashMap<Integer, CityAnimal> animals = new HashMap<Integer, CityAnimal>();
        animals.put(875, new CityAnimal("Sally", "Swann", 875));
        animals.put(678, new CityAnimal("Reginald", "Rabbit", 678));
        animals.put(549, new CityAnimal("Belinda", "Pidgeon", 549));
        animals.put(436, new CityAnimal("Jasper", "Squirrel", 436));

        // how could I remove an animal?

        animals.remove(436);

        // loop and print
        // printing our keys
        for (Integer key : animals.keySet()) {
            System.out.println(key); // this is going to print all of our keys
        }
        // printing our values
        for (CityAnimal animal : animals.values()) {
            System.out.println(animal); // this is going to print all of our animals
        }

        // we can also print everything
        for (Map.Entry<Integer, CityAnimal> entry : animals.entrySet()) {
            System.out.println(entry.getValue()); // value is the research #
            System.out.println(entry.getKey());  // key is the object

            */

//        // HashSets
//        // No order in a HashSet
//        // HashSet<Object> nameOfSet = new HashSet<>();
//        HashSet<CityAnimal> animals = new HashSet<>();
//
//        // how could I add stuff to this set?
//        animals.add(new CityAnimal("Tommy", "Beaver", 765));
//        animals.add(new CityAnimal("Ronald", "Rat", 981));
//        animals.add(new CityAnimal("Beth", "Owl", 872));
//        animals.add(new CityAnimal("Lewis", "Lion", 555));
//
//        // print this out
//        for (CityAnimal animal : animals) {
//            System.out.println(animal);
//
//        }

        // ArrayLists
        ArrayList<CityAnimal> animals = new ArrayList<>();


        // How do I found out the size
        System.out.println(animals.size()); // should be 0

        // add things to my list
        animals.add(new CityAnimal("George", "Fox", 871));
        animals.add(new CityAnimal("Tommy", "Beaver", 765));
        animals.add(new CityAnimal("Ronald", "Rat", 981));
        animals.add(new CityAnimal("Beth", "Owl", 872));

        // How do I print all the animals in my list?
        printAll(animals);

        // find Tommy
        findAnimalByName(animals, "Tommy");

        // Replace an item at a specific index
        animals.set(2, new CityAnimal("Rupert", "Possum", 301));
        System.out.println("use set to replace an index");
        printAll(animals);

        // remove
        animals.remove(1); // will remove Tommy
        System.out.println("removing index 1: Tommy");
        printAll(animals);

        // remove by object
        animals.remove(new CityAnimal("Rupert", "Possum", 301));
        System.out.println("Removing by object");
        printAll(animals);

    }

    // Helper methods
    private static void printAll(ArrayList<CityAnimal> animals) {
        for (CityAnimal a : animals) {
            System.out.println(a);
        }
    }
    private static void findAnimalByName(ArrayList<CityAnimal> animals, String name) {
        for (CityAnimal a : animals) {
            if (a.getName().equalsIgnoreCase(name)){
                System.out.println(a);
            }
        }
    }


}


import java.util.ArrayList;
import java.util.Arrays;

public class App {

    // The field's type is a String.
    // It can't change.
    public String value;

    public static void main(String[] args) {

        SoccerPlayer captain = new SoccerPlayer(10, "Carli", "Lloyd", "FW");
        SoccerPlayer goalKeeper = new SoccerPlayer(1, "Alyssa", "Naeher", "GK");
        System.out.printf("%-2s: %s, %s%n", captain.getNumber(), captain.getLastName(), captain.getPosition());
        System.out.printf("%-2s: %s, %s%n", goalKeeper.getNumber(), goalKeeper.getLastName(), goalKeeper.getPosition());

        // create an ArrayList with a default capacity
        ArrayList<SoccerPlayer> one = new ArrayList<SoccerPlayer>();
        // create an ArrayList with an explicit capacity
        ArrayList<SoccerPlayer> two = new ArrayList<SoccerPlayer>(23);
        // create an ArrayList based on another collection
        ArrayList<SoccerPlayer> three = new ArrayList<SoccerPlayer>(two);

        // Primitive types
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Double> doubles = new ArrayList<Double>();
        ArrayList<Boolean> booleans = new ArrayList<Boolean>();

        // When the diamond operator is used, the compiler infers the type from the left side of the assignment statement
        ArrayList<SoccerPlayer> players = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        // add
        ArrayList<SoccerPlayer> goalKeepers = new ArrayList<>();
        goalKeepers.add(new SoccerPlayer(1, "Alyssa", "Naeher", "GK"));
        goalKeepers.add(new SoccerPlayer(18, "Ashlyn", "Harris", "GK"));
        goalKeepers.add(new SoccerPlayer(21, "Adrianna", "Franch", "GK"));

        ArrayList<Integer> evenNumbers = new ArrayList<>();
        // Primitive types can be used, but they're automatically "boxed"
            // into their wrapper type.
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);

        // ArrayList<SoccerPlayer> goalKeepers = new ArrayList<>();
        goalKeepers.add(new SoccerPlayer(1, "Alyssa", "Naeher", "GK"));
        goalKeepers.add(new SoccerPlayer(18, "Ashlyn", "Harris", "GK"));

        SoccerPlayer franch = new SoccerPlayer(21, "Adrianna", "Franch", "GK");
        // Add Adrianna Franch to index 0.
        // She's now the first element.
        goalKeepers.add(0, franch);

        // ArrayList<Integer> evenNumbers = new ArrayList<>();
        evenNumbers.add(2);
        evenNumbers.add(6);

        // Add 4 in between 2 and 6, at index 1.
        evenNumbers.add(1, 4);

        // addAll
/*
        ArrayList<SoccerPlayer> goalKeepers = new ArrayList<>();
        goalKeepers.add(new SoccerPlayer(1, "Alyssa", "Naeher", "GK"));
        goalKeepers.add(new SoccerPlayer(18, "Ashlyn", "Harris", "GK"));
        goalKeepers.add(new SoccerPlayer(21, "Adrianna", "Franch", "GK"));

        ArrayList<SoccerPlayer> defense = new ArrayList<>();
        defense.add(new SoccerPlayer(14, "Emily", "Sonnett", "DF"));
        defense.add(new SoccerPlayer(19, "Crystal", "Dunn", "DF"));
        defense.add(new SoccerPlayer(20, "Casey", "Short", "DF"));

        ArrayList<SoccerPlayer> players = new ArrayList<>();
        players.addAll(goalKeepers);
        players.addAll(defense);

        // Initialize with Data

        ArrayList<SoccerPlayer> defense = new ArrayList<>(Arrays.asList(
                new SoccerPlayer(14, "Emily", "Sonnett", "DF"),
                new SoccerPlayer(19, "Crystal", "Dunn", "DF"),
                new SoccerPlayer(20, "Casey", "Short", "DF")
        ));

        ArrayList<Integer> oddNumbers = new ArrayList<>(Arrays.asList(1, 3, 5, 7));

        // Accessing Elements (use .get method)
*/
        ArrayList<SoccerPlayer> defense = new ArrayList<>();
        defense.add(new SoccerPlayer(4, "Becky", "Sauerbrunn", "DF"));
        defense.add(new SoccerPlayer(5, "Kelley", "O'Hara", "DF"));
        defense.add(new SoccerPlayer(7, "Abby", "Dahlkemper", "DF"));
        defense.add(new SoccerPlayer(11, "Ali", "Krieger", "DF"));
        defense.add(new SoccerPlayer(12, "Tierna", "Davidson", "DF"));
        defense.add(new SoccerPlayer(14, "Emily", "Sonnett", "DF"));
        defense.add(new SoccerPlayer(19, "Crystal", "Dunn", "DF"));
        defense.add(new SoccerPlayer(20, "Casey", "Short", "DF"));

        SoccerPlayer fifth = defense.get(4);              // the fifth player is index 4
        System.out.println(fifth.getLastName());          // Davidson

        System.out.println(defense.get(6).getLastName()); // Dunn

        ArrayList<Integer> evens = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println(evens.get(0)); // 2
        System.out.println(evens.get(1)); // 4
        System.out.println(evens.get(2)); // 6

        // With .size and a for loop, we can access each element via the .get method.

        for (int i = 0; i < defense.size(); i++) {
            SoccerPlayer sp = defense.get(i);
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }
        //There's a better way.

        // Enhanced for Loop

        /* Syntax
        for ([data type] [name] : [collection]) {
        }

        [data type] is the data type for an element in the [collection].
        [name] is a variable name that is valid only inside the code block.
        [collection] is an iterable collection like lists and arrays.
*/

        for (SoccerPlayer sp : defense) {
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }

        // Other Examples

        String[] colors = { "red", "orange", "yellow", "green", "blue", "purple" };
        for (String color : colors) {
            System.out.println(color);
        }

        ArrayList<String> colorList = new ArrayList<>(Arrays.asList(colors));
        for (String c : colorList) {
            System.out.println(c);
        }

        // Pros
        // Removes the need to manage indexes.
        // Automatically provides access to each element without explicitly retrieving it from the collection.
                // Guarantees that every element will be visited.
        // Cons
        // Doesn't provide an index, so we know the element, but not its position in the collection.
        // Replacing the variable value doesn't change the underlying collection. It only affects the loop variable.
/*
        for (SoccerPlayer sp : defense) {
            // this doesn't change anything in the `defense` list
            // it only affects the current block
            sp = new SoccerPlayer(18, "Ashlyn", "Harris", "GK");
            System.out.printf("%s: %s %s, %s%n", sp.getNumber(), sp.getFirstName(), sp.getLastName(), sp.getPosition());
        }

 */

        // Removing Elements

        // Use the .remove method to remove elements from the list.

        // Remove by Index

        ArrayList<SoccerPlayer> forwards = new ArrayList<>();
        forwards.add(new SoccerPlayer(2, "Mallory", "Pugh", "FW"));
        forwards.add(new SoccerPlayer(10, "Carli", "Lloyd", "FW"));
        forwards.add(new SoccerPlayer(13, "Lynn", "Williams", "FW"));
        forwards.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        forwards.add(new SoccerPlayer(17, "Tobin", "Heath", "FW"));
        forwards.add(new SoccerPlayer(22, "Jessica", "McDonald", "FW"));
        forwards.add(new SoccerPlayer(23, "Christen", "Press", "FW"));

        System.out.println(forwards.size());

        SoccerPlayer removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());
        removed = forwards.remove(3);
        System.out.printf("%s: %s, %s%n", removed.getNumber(), removed.getLastName(), removed.getPosition());

        System.out.println(forwards.size());

        /*
        The code above removes the element at index 3 three times.
        Each time it is a different player. Removing an element also reduces the size by one.
         */

        // Remove by Value

        // The second version of .remove accepts a value and returns nothing.
        // list stores Strings

        ArrayList<String> rivers = new ArrayList<>(
                Arrays.asList("Mississippi", "Amazon", "Nile", "Volga", "Zambezi", "Mekong"));

        rivers.remove("Nile"); // value is a String

        for (String name : rivers) {
            System.out.println(name);
        }

        // Output:
        // Mississippi
        // Amazon
        // Volga
        // Zambezi
        // Mekong


        // If our list is all Megan Rapinoes, the .remove method only removes the first one.

        ArrayList<SoccerPlayer> allRapinoes = new ArrayList<>();
        allRapinoes.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        allRapinoes.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        allRapinoes.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        allRapinoes.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));
        allRapinoes.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW"));

        SoccerPlayer rapinoe = new SoccerPlayer(15, "Megan", "Rapinoe", "FW");

        System.out.println(allRapinoes.size()); // 5

        allRapinoes.remove(rapinoe);

        System.out.println(allRapinoes.size()); // 4

    }





}

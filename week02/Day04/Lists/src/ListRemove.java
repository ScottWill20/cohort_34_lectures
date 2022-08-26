import java.util.ArrayList;

public class ListRemove {

    public static void main(String[] args) {

        ArrayList<SoccerPlayer> forwards = getForwards();
        SoccerPlayer rapinoe = getRapinoe();

        forwards.remove(rapinoe); // <-- This doesn't work.

        for (SoccerPlayer player : forwards) {
            System.out.println(player.getLastName());
        }
    }

    static ArrayList<SoccerPlayer> getForwards() {
        ArrayList<SoccerPlayer> forwards = new ArrayList<>();
        forwards.add(new SoccerPlayer(2, "Mallory", "Pugh", "FW"));
        forwards.add(new SoccerPlayer(10, "Carli", "Lloyd", "FW"));
        forwards.add(new SoccerPlayer(13, "Lynn", "Williams", "FW"));
        forwards.add(new SoccerPlayer(15, "Megan", "Rapinoe", "FW")); // <-- Rapinoe
        forwards.add(new SoccerPlayer(17, "Tobin", "Heath", "FW"));
        forwards.add(new SoccerPlayer(22, "Jessica", "McDonald", "FW"));
        forwards.add(new SoccerPlayer(23, "Christen", "Press", "FW"));
        return forwards;
    }

    static SoccerPlayer getRapinoe() {
        return new SoccerPlayer(15, "Megan", "Rapinoe", "FW"); // <-- Rapinoe
    }

    // Pugh
    // Lloyd
    // Williams
    // Rapinoe <-- Still in the list.
    // Heath
    // McDonald
    // Press

    // Walking through the code we:

    // Start with an ArrayList<SoccerPlayer> that contains the player, Megan Rapinoe.
    // Generate a second Megan Rapinoe object.
    // The values in both objects are the same, but when we try to remove by value, it fails.

    // Given a value, the .remove method removes the first element that is equal to the value.

    // @Override equals

    //The .equals method is an Object member, which means it's a member of all classes.
            // It accepts an Object parameter and returns a boolean:

    // true if the current object and the parameter are the same reference
    // false if they're not.

    @Override
    public boolean equals(Object value) {
        return true;
    }

    // See ListRemove
    // Run the remove demo a second time (ln10). Rapinoe should be successfully removed!





}

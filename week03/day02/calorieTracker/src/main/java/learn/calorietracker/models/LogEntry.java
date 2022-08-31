package learn.calorietracker.models;

public class LogEntry {
    // fields
    private int id;
    private String loggedOn; // date (string isnt the best choice here)
    private LogEntryType type;
    private String description;

    private int calories;

    // Constructors

    public LogEntry(int id, String loggedOn, LogEntryType type, String description, int calories) {
        this.id = id;
        this.loggedOn = loggedOn;
        this.type = type;
        this.description = description;
        this.calories = calories;
    }

    public LogEntry() {}

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(String loggedOn) {
        this.loggedOn = loggedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LogEntryType getType() {
        return type;
    }

    public void setType(LogEntryType type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Override toString

    @Override
    public String toString() {
        return String.format("Log Entry{ id: %s%n loggedOn: %s%n type: %s%n description: %s%n calories: %s%n }",
                id, loggedOn, type, description, calories);
    }

}

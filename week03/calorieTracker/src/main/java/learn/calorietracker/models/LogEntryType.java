package learn.calorietracker.models;

public enum LogEntryType {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack");

    private String displayText;

    LogEntryType(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}

package learn.calorietracker.ui;

// Presents user input and presents models to the user
// It will read and print from the console
// the view must be the only place in the app where this happens

import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;

import java.util.List;
import java.util.Scanner;

public class View {
    // we know the view will communicate with user, so we want a scanner in this class
    Scanner console = new Scanner(System.in);

    public int getMenuOption() {
        displayHeader("Main Menu");
        displayText("1. Add a Log Entry");
        displayText("2. View all Log Entries");
        displayText("3. Update a Log Entry");
        displayText("4. Delete a Log Entry");
        displayText("5. Exit the Program");
        return readInt("Select [1-5]",1,5);

    }

    // CREATE
    public LogEntry makeLogEntry() {
        LogEntry result = new LogEntry();
        // we don't need the ID
        result.setLoggedOn(readString("Logged On: "));
        result.setType(readLogEntryType("Log Entry Type: "));
        result.setDescription(readString("Description: "));
        result.setCalories(readInt("Calories: ", 1,5000));

        return result;
    }

    // READ
    public void displayLogEntries(List<LogEntry> logEntries) {
        for (LogEntry logEntry : logEntries) {
            displayText(String.format("ID: %s, Logged On: %s, Type: %s, Description: %s, Calories: %s",
                    logEntry.getId(),
                    logEntry.getLoggedOn(),
                    logEntry.getType(),
                    logEntry.getDescription(),
                    logEntry.getCalories()));
        }
    }

    // UPDATE & DELETE
    public int updateById() {
        displayText("Which entry ID would you like to modify?: ");
        // grab that entry id
        int id = readInt("Enter the ID: ",1,999999999);
        return id;
    }

    // Helper Methods
    public void displayHeader(String header) {
        System.out.println("");
        System.out.println(header);
        System.out.println("=".repeat(header.length()));
    }

    public void displayText(String line) {
        System.out.println(line);
    }

    public void displayErrors(List<String> errors) {
        displayHeader("Errors:");
        for (String error : errors) {
            displayText(error);
        }
        displayText("");
    }

    // we want to make methods for reading - we can do some defensive coding here - this never takes the place of validation in domain

    public int readInt(String prompt, int min, int max) {
        while(true) {
            String value = readString(prompt);
            try {
                int intValue = Integer.parseInt(value);
                if (intValue < min || intValue > max) {
                    System.out.printf("Sorry, that choice is out of bounds. Please choose a number between %S and %s.%n", min, max);
                    value = readString(prompt);
                } else {
                    return intValue;
                }
            } catch (NumberFormatException ex) {
                System.out.printf("%s is not a number.%n", value);
            }
        }
    }

    public String readString(String prompt) {
        displayText(prompt);
        String string = console.nextLine();
        if (string == null || string.isBlank()) {
            System.out.println("You must enter a value.");
            readString(prompt);
        }
        return string;
    }

    // we need a method to help us read type
    public LogEntryType readLogEntryType(String prompt) {
        displayHeader("Log Entry Types");
        for (LogEntryType type : LogEntryType.values()) {
            displayText(type.getDisplayText());
        }
        while (true) {
            String selection = readString(prompt);
            // our enums are uppercase
            selection = selection.toUpperCase().trim();
            try {
                return LogEntryType.valueOf(selection);
            } catch (IllegalArgumentException ex) {
                System.out.printf("%s is not a valid log entry type.%n", selection);
            }
        }
    }



} // closes class

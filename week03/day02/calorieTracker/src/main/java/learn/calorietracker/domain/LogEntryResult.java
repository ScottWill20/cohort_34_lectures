package learn.calorietracker.domain;

import learn.calorietracker.models.LogEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LogEntryResult {
// fields
    // these are going to be our failure messages if the user encounters an error
    private final ArrayList<String> messages = new ArrayList<>();
    private LogEntry logEntry; // this is going to allow us to deliver back either a success or failure
                                // (also sometimes referred to as payload)

    // getter for messages
    public ArrayList<String> getMessages() {
        return messages;
    }

    // getter and setter for LogEntry

    public LogEntry getLogEntry() {
        return logEntry;
    }
    public void setLogEntry(LogEntry logEntry) {
        this.logEntry = logEntry;
    }


    // Helper Methods

    public void addMessage(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.size() == 0;
    }


}

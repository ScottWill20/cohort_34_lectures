package learn.calorietracker;

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.data.LogEntryFileRepository;
import learn.calorietracker.models.LogEntry;

import java.util.List;

public class App {
    public static void main(String[] args) throws DataAccessException {
        LogEntryFileRepository repository = new LogEntryFileRepository("data/log-entries.csv");
        List<LogEntry> logEntries = repository.findAll();

        for(LogEntry logEntry : logEntries) {
            System.out.println(logEntry);
        }

    }
}

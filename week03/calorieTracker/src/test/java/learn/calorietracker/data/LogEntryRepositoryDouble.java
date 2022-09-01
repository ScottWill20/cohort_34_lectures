package learn.calorietracker.data;

import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;

import java.util.ArrayList;
import java.util.List;

public class LogEntryRepositoryDouble implements LogEntryRepository{
    @Override
   public List<LogEntry> findAll() throws DataAccessException {
        ArrayList<LogEntry> all = new ArrayList<>();
        all.add(new LogEntry(1, "2022-01-01 9:00 AM", LogEntryType.BREAKFAST, "Fremch Toast", 0500));
        all.add(new LogEntry(2, "2022-03-07 6:00 PM", LogEntryType.DINNER, "Spaghetti and Meatballs", 700));
        all.add(new LogEntry(3, "2022-01-01 11:00 AM", LogEntryType.SNACK, "Carrots", 100));

        return all;
    }

    @Override
    public LogEntry findById(int logEntryId) throws DataAccessException {
        for (LogEntry logEntry : findAll()) {
            if (logEntry.getId() == logEntryId) {
                return logEntry;
            }
        }
        return null;
    }

    @Override
    public LogEntry create(LogEntry logEntry) throws DataAccessException {
        // using a magic number here to get an ID  - so we can verify with our test that we are getting this ID back
        logEntry.setId(99);
        return logEntry;
    }

    @Override
    public boolean update(LogEntry logEntry) throws DataAccessException {
        return logEntry.getId() > 0;
    }

    @Override
    public boolean deleteById(int logEntryId) throws DataAccessException {
        return logEntryId != 99;
    }
}

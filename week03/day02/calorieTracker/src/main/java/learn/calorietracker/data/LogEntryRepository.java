package learn.calorietracker.data;

import learn.calorietracker.models.LogEntry;

import java.util.List;

public interface LogEntryRepository {
    // Read
    List<LogEntry> findAll() throws DataAccessException;
    // Read Helper to grab by ID
    LogEntry findById(int logEntryId) throws DataAccessException;
    // Create
    LogEntry create(LogEntry logEntry) throws DataAccessException;
    // Update
    boolean update(LogEntry logEntry);
    // Delete
    boolean delete(int logEntryId);

}

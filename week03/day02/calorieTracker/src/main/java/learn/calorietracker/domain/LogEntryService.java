package learn.calorietracker.domain;

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.data.LogEntryRepository;
import learn.calorietracker.models.LogEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogEntryService {
    private final LogEntryRepository repository;

    public LogEntryService(LogEntryRepository repository) {

        this.repository = repository;
    }




    //CREATE

    public LogEntryResult create(LogEntry logEntry) throws DataAccessException {
        // we are going to create our result here
        // we want to run it through some validation before we determine if we can successfully create it or not
        LogEntryResult result = validate(logEntry);
        // we want to check that the validation was successful. If it wasnt we are going to bail out here and return the result
        if (!result.isSuccess()) {
            return result;
        }
        // we are enforcing our id rule - we can't create something with an ID greater than 0 - if we try we
         // are going to give an error and bail out by returning the result
        if (logEntry.getId() > 0) {
            result.addMessage("cannot create existing log entry");
            return result;
        }
        // if we made it this far then we can use our repository.create method to create our log entry
        logEntry = repository.create(logEntry);

        // here we are using our setter to set our logEntry in our result class
        result.setLogEntry(logEntry);
        // return our result
        return result;

    }

    //READ
    public List<LogEntry> findAll() throws DataAccessException {
        return repository.findAll();
    }

    //UPDATE
    public LogEntryResult update(LogEntry logEntry) throws DataAccessException {
        LogEntryResult result = validate(logEntry);
        if (!result.isSuccess()) {
            return result; // we cant go further if the result fails
        }
        boolean updated = repository.update(logEntry);

        if (!updated) {
            result.addMessage(String.format("Log Entry with id %s does not exist", logEntry.getId()));
        }
        return result;
    }

    //DELETE

    public LogEntryResult deleteById(int logEntryId) throws DataAccessException {
        LogEntryResult result = new LogEntryResult();
        if (!repository.deleteById(logEntryId)) {
            result.addMessage(String.format("Log entry with id %s does not exist", logEntryId));
        }
        return result;
    }


    //HELPER METHODS

    public LogEntry findById(int logEntryId) throws DataAccessException {
        return repository.findById(logEntryId);
    }

    /*
     * we cannot add an id > 0
     * we need to check that loggedOn exists
     * we need a type
     * we need to make sure there is a description - not null and not blank
     * we need to make sure there are calories arent <= 0 or > 5000
     * if anything fails we want to let the user know
     */

    public LogEntryResult validate(LogEntry logEntry) {
        LogEntryResult result = new LogEntryResult();
        // if it's null
        if (logEntry == null) {
            result.addMessage("Log entry cannot be null");
            return result;
        }
        if (logEntry.getLoggedOn() == null || logEntry.getLoggedOn().isBlank()) {
            result.addMessage("LoggedOn is required");
            return result;
        }
        if (logEntry.getCalories() < 1 || logEntry.getCalories() > 5000) {
            result.addMessage("Calories must be between 1 and 5000");
            return result;
        }
        if (logEntry.getType() == null) {
            result.addMessage("type is required");
            return result;
        }
        if (logEntry.getDescription() == null || logEntry.getDescription().isBlank()) {
            result.addMessage("description is required");
            return result;
        }
        return result;
    }




}

package learn.calorietracker.ui;

// mediates between the view and the domain layer
// depends on the view and service classes
// you will never use console in the controller

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.domain.LogEntryResult;
import learn.calorietracker.domain.LogEntryService;
import learn.calorietracker.models.LogEntry;

import java.util.List;

public class Controller {
    // I'm moderating between the model view and the service from the domain, so I need a view and a service

    private final View view;
    private final LogEntryService service;

    public Controller(View view, LogEntryService service) {
        this.view = view;
        this.service = service;
    }

    // we eventually want to run our app

    public void run() {
        view.displayHeader("Welcome To The Calorie Tracker!");
        try {
            runMenu();
        } catch (DataAccessException ex) {
            view.displayText("Something went wrong.");
            view.displayText(ex.getMessage());
        }
        view.displayText("Goodbye!");

    }

    // run the menu
    private void runMenu() throws DataAccessException {
        boolean exit = false;
        while (!exit) {
            int selection = view.getMenuOption();
            switch (selection) {
                case 1: // create
                    addLogEntry();
                    break;
                case 2: // read
                    viewLogEntries();
                    break;
                case 3: // update
                    updateEntry();
                    break;
                case 4: // delete
                    deleteLogEntry();
                    break;
                case 5: // exit
                    exit = true;
                    break;
            }
        }
    }

    // CREATE
    private void addLogEntry() throws DataAccessException {
        LogEntry logEntry = view.makeLogEntry();

        LogEntryResult result = service.create(logEntry);
        if (result.isSuccess()) {
            view.displayText("Your Log was created successfully!");
        } else {
            view.displayErrors(result.getMessages());
        }
    }

    // READ

    private void viewLogEntries() throws DataAccessException {
        List<LogEntry> logEntries = service.findAll();
        view.displayLogEntries(logEntries);

    }

    // UPDATE
    private void updateEntry() throws DataAccessException {
        view.displayHeader("Update an Entry");
        LogEntry logEntry = service.findById(view.updateById());
        if (logEntry != null) {
            LogEntry updatedEntry = view.makeLogEntry();
            updatedEntry.setId(logEntry.getId()); // we don't change the ID for an update
            LogEntryResult result = service.update(updatedEntry);
            if (result.isSuccess()) {
                view.displayText("Your entry has been updated successfully!");
            } else {
                view.displayErrors(result.getMessages());
            }
        } else {
            view.displayErrors(List.of(String.format("There is no entry with ID %s%n",view.updateById())));
        }
    }

    // DELETE
    private void deleteLogEntry() throws DataAccessException {
        view.displayHeader("Delete an Entry");
        LogEntry logEntry = service.findById(view.updateById());
        if (logEntry != null) {
            LogEntryResult result = service.deleteById(logEntry.getId());
            if (result.isSuccess()){
                view.displayText("Your entry has been deleted successfully!");
            } else {
                view.displayErrors(result.getMessages());
            }
        } else {
            view.displayErrors(List.of(String.format("There is not entry with that ID.")));
        }
    }

}

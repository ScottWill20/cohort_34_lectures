package learn.calorietracker;

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.data.LogEntryFileRepository;
import learn.calorietracker.domain.LogEntryService;
import learn.calorietracker.models.LogEntry;
import learn.calorietracker.ui.Controller;
import learn.calorietracker.ui.View;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // setting up all the classes needed to run the app
        LogEntryFileRepository repository = new LogEntryFileRepository("data/log-entries.csv");
        View view = new View();
        LogEntryService service = new LogEntryService(repository);
        Controller controller = new Controller(view,service);

        controller.run();
    }
}

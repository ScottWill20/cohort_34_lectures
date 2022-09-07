package learn.calorietracker;

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.data.LogEntryFileRepository;
import learn.calorietracker.domain.LogEntryService;
import learn.calorietracker.models.LogEntry;
import learn.calorietracker.ui.Controller;
import learn.calorietracker.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@ComponentScan
@PropertySource("classpath:data.properties") // this will tell the app where to look
public class App {
    public static void main(String[] args) {
        configureManuallyAndRun();
    }

    // With annotations
    private static void configureWithAnnotationsAndRun() {
        ApplicationContext container = new AnnotationConfigApplicationContext(App.class);
        // this stays the same
        Controller controller = container.getBean(Controller.class);

        controller.run();

    }

    //with XML
    private static void configureWithXMLandRun() {
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-config.xml");
        Controller controller = container.getBean(Controller.class);
        controller.run();
    }

    // good ol' manual
    private static void configureManuallyAndRun() {
        LogEntryFileRepository repository = new LogEntryFileRepository("./data/log-entries.csv");
        LogEntryService service = new LogEntryService(repository);
        View view = new View();
        Controller controller = new Controller(view,service);
        controller.run();
    }

}

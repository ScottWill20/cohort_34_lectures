package learn.solarfarm;

import learn.solarfarm.data.DataAccessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws DataAccessException {
        SpringApplication.run(App.class,args);
    }

}

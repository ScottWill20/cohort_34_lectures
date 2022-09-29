package learn.solarfarm;

import com.mysql.cj.jdbc.MysqlDataSource;
import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.data.SolarPanelJdbcRepositoryTemplate;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.models.SolarPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@ComponentScan
public class App {
    public static void main(String[] args) throws DataAccessException {
        System.out.println("Welcome to Solar Farm!");

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        SolarPanelRepository repository = context.getBean(SolarPanelJdbcRepositoryTemplate.class);

        List<SolarPanel> panels = repository.findAll();

        for(SolarPanel solarPanel : panels){
            System.out.printf("ID: %s Section: %s Row: %s Column: %s Year Installed: %s Material: %s is Tracking: %s%n", solarPanel.getId(), solarPanel.getSection(), solarPanel.getRow(), solarPanel.getColumn(), solarPanel.getYearInstalled(), solarPanel.getMaterial(), solarPanel.isTracking());
        }

    }

    // NOTE: THIS IS TEMPORARY !!!!!!

    @Bean
    public DataSource getDataSource() {
        MysqlDataSource result = new MysqlDataSource();
        // Url is for the test database.
        result.setUrl("jdbc:mysql://localhost:3306/solar_farm");
        result.setUser("root");
        result.setPassword("top-secret-password");
        return result;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

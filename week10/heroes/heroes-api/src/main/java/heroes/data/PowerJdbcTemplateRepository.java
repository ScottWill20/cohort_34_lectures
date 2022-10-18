package heroes.data;

import heroes.models.Power;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PowerJdbcTemplateRepository implements PowerRepository {

    private final JdbcTemplate jdbcTemplate;

    public PowerJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Power> findAll() {
        String sql = "select power_id, name from power;";
        return jdbcTemplate.query(sql, new PowerMapper());
    }
}

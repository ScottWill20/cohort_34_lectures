package learn.solarfarm.data;

import learn.solarfarm.models.Material;
import learn.solarfarm.models.SolarPanel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Repository
public class SolarPanelJdbcRepositoryTemplate implements SolarPanelRepository{

    private final JdbcTemplate jdbcTemplate;

    public SolarPanelJdbcRepositoryTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<SolarPanel> mapper = (resultSet, rowIndex) ->{
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setId(resultSet.getInt("id"));
        solarPanel.setSection(resultSet.getString("section"));
        solarPanel.setRow(resultSet.getInt("row"));
        solarPanel.setColumn(resultSet.getInt("column"));
        solarPanel.setYearInstalled(resultSet.getInt("year_installed"));

        Material material = Material.valueOf(resultSet.getString("material"));
        solarPanel.setMaterial(material);

        solarPanel.setTracking(resultSet.getBoolean("is_tracking"));

        return solarPanel;
    };


    @Override
    public List<SolarPanel> findAll() throws DataAccessException {
        final String sql = "select id, section, `row`, `column`, year_installed, material, is_tracking " +
                "from solar_panel " +
                "order by section, `row`, `column`;";

        // this is an inline approach
//        return jdbcTemplate.query(sql, (resultSet, rowIndex) ->{
//            SolarPanel solarPanel = new SolarPanel();
//            //TODO - set some fields
//            solarPanel.setId(resultSet.getInt("id"));
//            solarPanel.setSection(resultSet.getString("section"));
//            solarPanel.setRow(resultSet.getInt("row"));
//            solarPanel.setColumn(resultSet.getInt("column"));
//            solarPanel.setYearInstalled(resultSet.getInt("year_installed"));
//
//            Material material = Material.valueOf(resultSet.getString("material"));
//            solarPanel.setMaterial(material);
//
//            solarPanel.setTracking(resultSet.getBoolean("is_tracking"));
//
//            return solarPanel;
            //});

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        // ; drop table solar_panel; - BAD
        final String sql = "select id, section, `row`, `column`, year_installed, material, is_tracking " +
                "from solar_panel " +
                "where section = ? " +
                "order by section, `row`, `column`;";

        return jdbcTemplate.query(sql, mapper, section);
    }

    @Override
    public SolarPanel findById(int id) throws DataAccessException {
        final String sql = "select id, section, `row`, `column`, year_installed, material, is_tracking " +
                "from solar_panel " +
                "where id = ?";

        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    @Override
    public SolarPanel create(SolarPanel solarPanel) throws DataAccessException {
        final String sql = "insert into solar_panel (section, `row`, `column`, year_installed, material, is_tracking) " +
                "values (?, ?, ?, ?, ?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        // we need to pass 2 things to the update method - a lambda and a key holder
// super weird to use the update method here but we are updating the database - we will also use it for update and delete
        int rowsAffected = jdbcTemplate.update(connection -> {
            // this will look similar to row mapper
            // first arg is our query - second is an enum - statement.RETURN_GENERATED_KEY
            // when we create our statement to run here we are saying we want our key back

            // this is the opposite of a row mapper - A row mapper is taking the result value and putting it in our model - here we are taking a value from our model and putting it in our statement
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solarPanel.getSection());
            statement.setInt(2, solarPanel.getRow());
            statement.setInt(3, solarPanel.getColumn());
            statement.setInt(4, solarPanel.getYearInstalled());
            statement.setString(5, solarPanel.getMaterial().toString());
            statement.setBoolean(6, solarPanel.isTracking());
            // we use these parameter indexes to refer to our question marks - these start at 1 and not 0 - you just need to remember that
            return statement;
        }, keyHolder);// second arg of keyHolder is passed here

        if (rowsAffected == 0) {
            return null;
        }

        solarPanel.setId(keyHolder.getKey().intValue()); // id comes from our keyHolder

        return solarPanel;
    }

    @Override
    public boolean update(SolarPanel solarPanel) throws DataAccessException {
        final String sql = "update solar_panel set " +
                "section = ?, " +
                "`row` = ?, " +
                "`column` = ?, " +
                "year_installed = ?, " +
                "material = ?, " +
                "is_tracking = ? " +
                "where id = ?;";

        int rowsUpdated = jdbcTemplate.update(sql,
                solarPanel.getSection(),
                solarPanel.getRow(),
                solarPanel.getColumn(),
                solarPanel.getYearInstalled(),
                solarPanel.getMaterial().toString(),
                solarPanel.isTracking(),
                solarPanel.getId());

        return rowsUpdated > 0;
    }

    @Override
    public boolean deleteById(int id) throws DataAccessException {
        final String sql = "delete from solar_panel where id = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }
}

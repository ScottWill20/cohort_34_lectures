package heroes.data;

import heroes.models.Power;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerMapper implements RowMapper<Power> {
    @Override
    public Power mapRow(ResultSet rs, int rowNum) throws SQLException {
        Power power = new Power();
        power.setPowerId(rs.getInt("power_id"));
        power.setName(rs.getString("name"));
        return power;
    }
}

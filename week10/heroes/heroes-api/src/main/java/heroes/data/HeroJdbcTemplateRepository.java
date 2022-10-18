package heroes.data;

import heroes.models.Hero;
import heroes.models.Power;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class HeroJdbcTemplateRepository implements HeroRepository {

    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Hero> heroMapper = (rs, rowNum) -> {
        Hero hero = new Hero();
        hero.setHeroId(rs.getInt("hero_id"));
        hero.setSuperName(rs.getString("super_name"));
        hero.setRealName(rs.getString("real_name"));
        hero.setImageUrl(rs.getString("image_url"));
        return hero;
    };

    public HeroJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> findAll() {
        String sql = "select hero_id, super_name, real_name, image_url from hero;";
        List<Hero> heroes = jdbcTemplate.query(sql, heroMapper);
        for (Hero h : heroes) {
            addPowers(h);
        }
        return heroes;
    }

    @Override
    public Hero findById(int heroId) {

        String sql = "select hero_id, super_name, real_name, image_url "
                + "from hero "
                + "where hero_id = ?;";

        Hero hero = jdbcTemplate.query(sql, heroMapper, heroId).stream()
                .findFirst()
                .orElse(null);

        if (hero != null) {
            addPowers(hero);
        }

        return hero;
    }

    @Transactional
    @Override
    public Hero add(Hero hero) {

        String sql = "insert into hero (super_name, real_name, image_url) values (?,?,?);";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update((conn) -> {
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, hero.getSuperName());
            statement.setString(2, hero.getRealName());
            statement.setString(3, hero.getImageUrl());
            return statement;
        }, keyHolder);

        if (rowsAffected > 0) {
            hero.setHeroId(keyHolder.getKey().intValue());
            updatePowers(hero);
            return hero;
        }

        return null;
    }

    @Transactional
    @Override
    public boolean update(Hero hero) {

        String sql = "update hero set "
                + "super_name = ?, "
                + "real_name = ?, "
                + "image_url = ? "
                + "where hero_id = ?;";

        int rowsAffected = jdbcTemplate.update(sql,
                hero.getSuperName(),
                hero.getRealName(),
                hero.getImageUrl(),
                hero.getHeroId());

        if (rowsAffected > 0) {
            updatePowers(hero);
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public boolean deleteById(int heroId) {
        jdbcTemplate.update("delete from hero_power where hero_id = ?;", heroId);
        return jdbcTemplate.update("delete from hero where hero_id = ?;", heroId) > 0;
    }

    private void addPowers(Hero hero) {

        String sql = "select p.power_id, p.name "
                + "from power p "
                + "inner join hero_power hp on p.power_id = hp.power_id "
                + "where hp.hero_id = ?;";

        List<Power> powers = jdbcTemplate.query(sql, new PowerMapper(), hero.getHeroId());
        hero.setPowers(powers);
    }

    private void updatePowers(Hero hero) {
        jdbcTemplate.update("delete from hero_power where hero_id = ?;", hero.getHeroId());
        for (Power p : hero.getPowers()) {
            jdbcTemplate.update(
                    "insert into hero_power (hero_id, power_id) values (?,?);",
                    hero.getHeroId(),
                    p.getPowerId());
        }
    }
}

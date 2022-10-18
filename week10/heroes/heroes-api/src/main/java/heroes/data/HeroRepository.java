package heroes.data;

import heroes.models.Hero;

import java.util.List;

public interface HeroRepository {
    List<Hero> findAll();

    Hero findById(int heroId);

    Hero add(Hero hero);

    boolean update(Hero hero);

    boolean deleteById(int heroId);
}

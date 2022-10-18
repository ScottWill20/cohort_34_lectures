package heroes.domain;

import heroes.data.HeroRepository;
import heroes.models.Hero;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
// import javax.xml.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class HeroService {

    private final HeroRepository repository;
    private final Validator validator;

    public HeroService(HeroRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public List<Hero> findAll() {
        return repository.findAll();
    }

    public Hero findById(int heroId) {
        return repository.findById(heroId);
    }

    public Result<Hero> save(Hero hero) {
        Result<Hero> result = validate(hero);
        if (!result.isSuccess()) {
            return result;
        }

        if (hero.getHeroId() > 0) { // update
            boolean success = repository.update(hero);
            if (!success) {
                String msg = String.format("heroId %s not found", hero.getHeroId());
                result.addMessage(msg, ResultType.NOT_FOUND);
            }
        } else { //add
            Hero withId = repository.add(hero);
            result.setPayload(withId);
        }

        return result;
    }

    public boolean deleteById(int heroId) {
        return repository.deleteById(heroId);
    }

    private Result<Hero> validate(Hero hero) {

        Result<Hero> result = new Result<>();
        if (hero == null) {
            result.addMessage("hero cannot be null", ResultType.INVALID);
            return result;
        }

        Set<ConstraintViolation<Hero>> violations = validator.validate(hero);
        for (var violation : violations) {
            result.addMessage(violation.getMessage(), ResultType.INVALID);
        }

        return result;
    }
}

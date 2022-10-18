package heroes.domain;

import heroes.data.PowerRepository;
import heroes.models.Power;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerService {

    private final PowerRepository repository;

    public PowerService(PowerRepository repository) {
        this.repository = repository;
    }

    public List<Power> findAll() {
        return repository.findAll();
    }
}

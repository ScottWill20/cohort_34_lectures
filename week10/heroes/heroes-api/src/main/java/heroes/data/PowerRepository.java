package heroes.data;

import heroes.models.Power;

import java.util.List;

public interface PowerRepository {
    List<Power> findAll();
}

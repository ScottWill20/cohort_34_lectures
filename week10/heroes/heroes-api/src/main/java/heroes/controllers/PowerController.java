package heroes.controllers;

import heroes.domain.PowerService;
import heroes.models.Power;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/power")
public class PowerController {

    private final PowerService service;

    public PowerController(PowerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Power> findAll() {
        return service.findAll();
    }
}

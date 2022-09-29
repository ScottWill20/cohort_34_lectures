package learn.solarfarm.controllers;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solarpanel")
public class SolarPanelController {

    private final SolarPanelService service;
    public SolarPanelController(SolarPanelService service) {
        this.service = service;
    }

    @GetMapping
    public List<SolarPanel> findAllPanels() throws DataAccessException {
        return service.findAll();
    }

    @GetMapping("/section/{section}")
    public List<SolarPanel> findBySection(@PathVariable String section) throws DataAccessException {
        return service.findBySection(section);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolarPanel> findById(@PathVariable int id) throws DataAccessException {
        SolarPanel solarPanel = service.findById(id);
        if (solarPanel == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(solarPanel,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?/* or Object */> create(@RequestBody SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = service.create(solarPanel);
        if (!result.isSuccess()) {
            /// return a 400 status
            return new ResponseEntity<>(result.getErrorMessages(), HttpStatus.BAD_REQUEST); // 400
        }
        // happy path - CREATED 201
        return new ResponseEntity<>(result.getSolarPanel(), HttpStatus.CREATED); // 201
    }

}

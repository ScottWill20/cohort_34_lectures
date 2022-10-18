package heroes.controllers;

import heroes.domain.HeroService;
import heroes.domain.Result;
import heroes.domain.ResultType;
import heroes.models.Hero;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

    private final HeroService service;

    public HeroController(HeroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Hero> getHeroes() {
        return service.findAll();
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Hero> getHero(@PathVariable int heroId) {
        Hero hero = service.findById(heroId);
        if (hero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hero);
    }

    @PostMapping
    public ResponseEntity<Object> post(@Valid @RequestBody Hero hero, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> messages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }

        Result<Hero> result = service.save(hero);

        if (result.isSuccess()) {
            return ResponseEntity.created(
                            URI.create("http://localhost:8080/api/hero/" + result.getPayload().getHeroId()))
                    .body(hero);
        }
        return makeResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{heroId}")
    public ResponseEntity<Object> put(@PathVariable int heroId, @Valid @RequestBody Hero hero, BindingResult bindingResult) {

        if (hero == null || hero.getHeroId() != heroId) {
            return new ResponseEntity<>(List.of("hero cannot be null"), HttpStatus.BAD_REQUEST);
        }

        if (bindingResult.hasErrors()) {
            List<String> messages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }

        Result<Hero> result = service.save(hero);
        return makeResponseEntity(result, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{heroId}")
    public ResponseEntity<Void> delete(@PathVariable int heroId) {
        boolean success = service.deleteById(heroId);
        if (success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private <T> ResponseEntity<Object> makeResponseEntity(Result<T> result, HttpStatus status) {
        if (result.getType() == ResultType.INVALID) {
            return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
        } else if (result.getType() == ResultType.NOT_FOUND) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result.getPayload(), status);
    }
}

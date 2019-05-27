package be.kevinbaes.bap.webfluxr2dbc.web;

import be.kevinbaes.bap.webfluxr2dbc.persistence.Goal;
import be.kevinbaes.bap.webfluxr2dbc.persistence.GoalRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/goal")
public class GoalController {

  private final GoalRepository goalRepository;

  public GoalController(GoalRepository goalRepository) {
    this.goalRepository = goalRepository;
  }

  @GetMapping
  public Flux<Goal> findAll(@RequestParam(value = "limit", required = false) Integer limit) {
        if(limit == null) {
            return goalRepository.findAll();
        }

        return goalRepository.findWithLimit(limit);
  }

  @PostMapping
  public Mono<Goal> create(@RequestBody Goal goal) {
    return goalRepository.save(goal);
  }

}

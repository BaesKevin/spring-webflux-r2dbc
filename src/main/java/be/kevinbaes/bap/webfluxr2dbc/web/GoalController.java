package be.kevinbaes.bap.webfluxr2dbc.web;

import be.kevinbaes.bap.webfluxr2dbc.persistence.CustomGoalRepository;
import be.kevinbaes.bap.webfluxr2dbc.persistence.Goal;
import be.kevinbaes.bap.webfluxr2dbc.persistence.GoalRepository;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/goal")
public class GoalController {

  private final CustomGoalRepository customGoalRepository;
  private final GoalRepository goalRepository;
  private final ReactiveTransactionManager transactionManager;

  public GoalController(CustomGoalRepository customGoalRepository, GoalRepository goalRepository, ReactiveTransactionManager transactionManager) {
    this.customGoalRepository = customGoalRepository;
    this.goalRepository = goalRepository;
    this.transactionManager = transactionManager;

  }

  @GetMapping
  @Transactional
  public Flux<Goal> findAll() {
    return goalRepository.findAll();
  }

  @PostMapping
  public Mono<Goal> create(@RequestBody Goal goal) {
    return goalRepository.save(goal);
  }

}

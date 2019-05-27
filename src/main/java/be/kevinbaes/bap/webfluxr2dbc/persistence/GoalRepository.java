package be.kevinbaes.bap.webfluxr2dbc.persistence;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface GoalRepository extends ReactiveCrudRepository<Goal, Integer> {

  @Query("select * from goal limit :count")
  Flux<Goal> findWithLimit(int limit);
}

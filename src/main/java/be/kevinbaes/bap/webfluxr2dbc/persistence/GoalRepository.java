package be.kevinbaes.bap.webfluxr2dbc.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends ReactiveCrudRepository<Goal, Integer> {
}

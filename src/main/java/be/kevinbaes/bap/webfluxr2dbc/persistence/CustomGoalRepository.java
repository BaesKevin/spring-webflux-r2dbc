package be.kevinbaes.bap.webfluxr2dbc.persistence;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomGoalRepository {
  private final DatabaseClient client;

  public CustomGoalRepository(DatabaseClient client) {
    this.client = client;
  }

  public Flux<Goal> findAll() {
    return client
        .execute()
        .sql("select * from goal")
        .map((r, rm) -> new Goal(r.get("id", Integer.class), r.get("name", String.class)))
        .all();
  }
  public Mono<Integer> insert(String name) {
    return client
        .execute().sql("INSERT INTO goal (name) VALUES($1)") //
        .bind(0, name) //
        .fetch()
        .rowsUpdated();
  }

}

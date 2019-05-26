package be.kevinbaes.bap.webfluxr2dbc.persistence.config;

import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class DbInitializer {
  private final DatabaseClient databaseClient;

  public DbInitializer(DatabaseClient databaseClient) {
    this.databaseClient = databaseClient;
  }

  @PostConstruct
  public void createSchema() {
    Flux<Map<String, Object>> dropTable = databaseClient.execute().sql("drop table if exists goal").fetch().all();
    Flux<Map<String, Object>> createTable = databaseClient.execute().sql("create table goal\n" +
        "(\n" +
        "\tid serial not null\n" +
        "\t\tconstraint goal_pkey\n" +
        "\t\t\tprimary key,\n" +
        "\tname varchar(50)\n" +
        ");").fetch().all();


    dropTable.thenMany(createTable).blockLast();
  }
}

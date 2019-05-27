package be.kevinbaes.bap.webfluxr2dbc.persistence;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface DeviceEventRepository extends ReactiveCrudRepository<DeviceEvent, Integer> {

  @Query("select * from device_event limit :count")
  Flux<DeviceEvent> findWithLimit(int limit);

}

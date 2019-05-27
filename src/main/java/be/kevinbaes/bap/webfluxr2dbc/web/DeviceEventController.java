package be.kevinbaes.bap.webfluxr2dbc.web;


import be.kevinbaes.bap.webfluxr2dbc.persistence.DeviceEvent;
import be.kevinbaes.bap.webfluxr2dbc.persistence.DeviceEventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/event")
public class DeviceEventController {

  private DeviceEventRepository eventRepository;

  public DeviceEventController(DeviceEventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @GetMapping
  public Flux<DeviceEvent> findAll(@RequestParam(value = "limit", required = false) Integer limit) {
    if(limit == null) {
      return eventRepository.findAll();
    }

    return eventRepository.findWithLimit(limit);
  }

}

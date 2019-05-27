package be.kevinbaes.bap.webfluxr2dbc.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceEvent {

  @Id
  private int id;
  private long receivedTime;
  private long lattitude;
  private long longitude;

}

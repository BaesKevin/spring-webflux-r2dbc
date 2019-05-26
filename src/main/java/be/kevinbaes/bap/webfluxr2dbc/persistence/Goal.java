package be.kevinbaes.bap.webfluxr2dbc.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goal {
  /**
   * Boxed type so R2dbc knows to bind null when inserting, using int results in id 0 being inserted always
   */
  @Id
  private Integer id;
  private String name;

  public Goal(String name) {
    this.name = name;
  }
}

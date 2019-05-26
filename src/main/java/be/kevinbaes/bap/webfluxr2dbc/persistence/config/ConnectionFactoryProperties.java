package be.kevinbaes.bap.webfluxr2dbc.persistence.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * contains all possible configuration properties for R2DBC drivers
 */
@Configuration
@Data
@ConfigurationProperties(prefix="datasource")
public class ConnectionFactoryProperties {
  private String driver;
  private String host;
  private int port;
  private String protocol = "";
  private String username;
  private String password;
  private String database;
}

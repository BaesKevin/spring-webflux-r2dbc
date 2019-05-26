package be.kevinbaes.bap.webfluxr2dbc.persistence.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories(basePackages = {"be.kevinbaes.bap.webfluxr2dbc.persistence"})
@EnableTransactionManagement
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {

  private ConnectionFactoryProperties dataSourceProperties;

  public R2dbcConfiguration(ConnectionFactoryProperties dataSourceProperties) {
    this.dataSourceProperties = dataSourceProperties;
  }

  /**
   * The reactive equivalent of PlatformTransactionManager
   */
  @Bean
  ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
    return new R2dbcTransactionManager(connectionFactory);
  }

  /**
   * Uses the R2DBC ConnectionFactory discovery and passes all possible configuration properties
   * @return a driver specific connectionfactory
   */
  @Override
  @Bean
  public ConnectionFactory connectionFactory() {
    return ConnectionFactories.get(ConnectionFactoryOptions.builder()
        .option(DRIVER, dataSourceProperties.getDriver())
        .option(PROTOCOL, dataSourceProperties.getProtocol())
        .option(HOST, dataSourceProperties.getHost())
        .option(PORT, dataSourceProperties.getPort())
        .option(USER, dataSourceProperties.getUsername())
        .option(PASSWORD, dataSourceProperties.getPassword())
        .option(DATABASE, dataSourceProperties.getDatabase())
        .build());
  }
}

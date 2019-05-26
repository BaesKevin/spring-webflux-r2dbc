package be.kevinbaes.bap.webfluxr2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
public class WebfluxR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxR2dbcApplication.class, args);
	}

}

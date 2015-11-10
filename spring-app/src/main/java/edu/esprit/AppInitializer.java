package edu.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//OR
@SpringBootApplication
public class AppInitializer extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(AppInitializer.class, args);
	}

	@Override
	protected final SpringApplicationBuilder configure(
			final SpringApplicationBuilder application) {
		return application.sources(AppInitializer.class);
	}
}

package org.sevenzero.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AppStart extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppStart.class);
}
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(AppStart.class, args);
		
	}
	
}

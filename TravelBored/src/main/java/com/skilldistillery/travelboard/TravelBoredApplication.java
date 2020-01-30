package com.skilldistillery.travelboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TravelBoredApplication extends SpringBootServletInitializer {
	
	 @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(TravelBoredApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(TravelBoredApplication.class, args);
	}

}

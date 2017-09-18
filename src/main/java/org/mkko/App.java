package org.mkko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application that runs a web based converter for Roman numbers.
 * 
 * @author mkokott
 *
 */
@SpringBootApplication
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
}

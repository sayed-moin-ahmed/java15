package com.java15.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://docs.oracle.com/javase/tutorial/index.html
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/module-summary.html
 * https://docs.oracle.com/javase/specs/index.html
 */
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		System.out.println("Started...");
	}

}

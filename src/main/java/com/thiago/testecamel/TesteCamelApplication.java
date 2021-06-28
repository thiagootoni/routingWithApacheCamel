package com.thiago.testecamel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteCamelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesteCamelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("No arrrr!!!!");
		
	}

}

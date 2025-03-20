package com.mahpud.inal;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class InalApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();
		Properties props = System.getProperties();
		props.setProperty("DB_URL", dotenv.get("DB_URL"));
		props.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		props.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		props.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));

		SpringApplication.run(InalApplication.class, args);
	}

}

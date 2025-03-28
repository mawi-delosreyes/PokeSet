package com.pokeset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.pokeset"})
@EnableAutoConfiguration
public class PokesetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokesetApplication.class, args);
	}

}

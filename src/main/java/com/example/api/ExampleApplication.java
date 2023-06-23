package com.example.api;

import com.example.api.data.Country;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ExampleApplication {
	public static void main (final String[] args){

		//Country c = new Country(1L, "Colombia");
		//System.out.println("Hello Country %s".formatted(c.getName()));

		SpringApplication.run(ExampleApplication.class, args);

	}



}
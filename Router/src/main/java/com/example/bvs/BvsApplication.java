package com.example.bvs;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class BvsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BvsApplication.class, args);
	}

}

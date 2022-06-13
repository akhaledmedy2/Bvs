package com.consumer.consumer1;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class Consumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}

}

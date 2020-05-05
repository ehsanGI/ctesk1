package com.meteo.ctask1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CodingTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(CodingTask1Application.class, args);
	}

}

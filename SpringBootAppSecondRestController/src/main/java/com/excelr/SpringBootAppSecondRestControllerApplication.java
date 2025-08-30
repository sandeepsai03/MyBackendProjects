package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.excelr.client")
public class SpringBootAppSecondRestControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppSecondRestControllerApplication.class, args);
	}

}

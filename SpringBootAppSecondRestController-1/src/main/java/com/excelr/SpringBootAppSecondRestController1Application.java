package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.excelr.client")
public class SpringBootAppSecondRestController1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppSecondRestController1Application.class, args);
	}

}

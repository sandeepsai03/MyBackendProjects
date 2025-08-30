package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApiGatewayApplication.class, args);
	}

}

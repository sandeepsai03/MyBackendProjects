package com.excelr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods= false)

public class Config {

	@Bean
	public Car methodFromConfig() {
		
		Car c1=new Car();
		c1.setCarPrice(70000);
		c1.setCarName("nano");
		
		return c1;
	}
	
}

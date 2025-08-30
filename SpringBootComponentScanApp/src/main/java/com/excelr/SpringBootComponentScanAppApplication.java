package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.excelr,in.tcs")
public class SpringBootComponentScanAppApplication {

	public static void main(String[] args) {
		//IOC stsarts
		ApplicationContext con=SpringApplication.run(SpringBootComponentScanAppApplication.class, args);
		
		
	}

}

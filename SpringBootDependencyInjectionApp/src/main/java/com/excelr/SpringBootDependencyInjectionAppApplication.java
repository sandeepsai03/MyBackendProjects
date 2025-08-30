package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDependencyInjectionAppApplication {

	public static void main(String[] args) {
		//ICO starts
		ApplicationContext con=SpringApplication.run(SpringBootDependencyInjectionAppApplication.class, args);
		
		//getBean()
		B b1=con.getBean(B.class);
		b1.bClassMethod();
	}

}

package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootAppFirstApplication {

	public static void main(String[] args) {
		
		//IOC starts
	ApplicationContext con=SpringApplication.run(SpringBootAppFirstApplication.class, args);
	
	System.out.println("welcome to springBoot");
	
	//call getBean()
	A a1=con.getBean(A.class);
	
	
	}

}

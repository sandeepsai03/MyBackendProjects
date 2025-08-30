package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		//IOC starts
		
		ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		
		//call getBean()
		
		Car c1=con.getBean("car1",Car.class);
		
	}
}

package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args) {
	
	//IOC starts
	
	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
	
	//call getBean() for car 1st

	Car c1=con.getBean("car1",Car.class);
	System.out.println(c1);
}
}

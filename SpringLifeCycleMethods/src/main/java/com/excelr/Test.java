package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	
	//IOC starts
	
			ConfigurableApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
			
			//call getBean() for car 1st
		
			Engine e1=con.getBean("e1",Engine.class);
	
			//call getBean() for motor 1st
			Motor m1=con.getBean("m1",Motor.class);
		
			con.close();
		
}
}

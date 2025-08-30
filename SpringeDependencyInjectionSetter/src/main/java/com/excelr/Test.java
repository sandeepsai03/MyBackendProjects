package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	
	//IOC starts
	
	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
	
	//call getBean() for car 1st

 B res1=con.getBean("b1",B.class);
	res1.bClassMethod();
	
}
}

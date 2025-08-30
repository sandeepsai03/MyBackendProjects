package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
	//IOC starts
		
		ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
		
		//call getBean()
		
		Student s1=con.getBean("stu1",Student.class);
		System.out.println(s1);
		
	}
}

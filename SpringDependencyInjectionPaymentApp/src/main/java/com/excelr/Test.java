package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	
	//IOC starts
	
	ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
	
	//call getBean()
	
	BillCollector b1=con.getBean("bc",BillCollector.class);
	b1.takePayment();
}
}

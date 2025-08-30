package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {
	
	//IOC starts
	
			ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");
			
			//call getBean() for car 1st
		
			Car c1=con.getBean("car1",Car.class);
			System.out.println(c1.hashCode());//494586676

			//call getBean() for car 2nd
			
			Car c2=con.getBean("car1",Car.class);///note: we are calling getbean() car class two times but same hashcode is given it means single object is created
			System.out.println(c2.hashCode());//494586676 

			//call getBean() for motor 1st
			Motor m1=con.getBean("motor1",Motor.class);
			System.out.println(m1.hashCode());//494586676
			
			//call getBean() for motor 2nd
			Motor m2=con.getBean("motor1",Motor.class);
			System.out.println(m2.hashCode());//	508198356
}
}

package com.excelr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        
        // IOC starts with Java-based configuration
        ApplicationContext con = new AnnotationConfigApplicationContext(Config.class); // ✅ FIXED
        
        // call getBean() for car 1st
        Car c1 = con.getBean("methodFromConfig", Car.class);
        System.out.println(c1);
    }
}

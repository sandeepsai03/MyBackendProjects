package com.excelr;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component ///it is used to create objects and converts normal class intpo springBean class
public class A {
 
	public A() {
		System.out.println("A class constructor executed");
	}
}

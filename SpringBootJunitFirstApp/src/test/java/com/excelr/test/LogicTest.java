package com.excelr.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.excelr.logic.LogicClass;

public class LogicTest {

	private static LogicClass lc;
	
	@BeforeAll
	public static void init() {
		lc=new LogicClass();
	}
	
	@AfterAll
	public static void destroy() {
		lc=null;
	}
	
	@Test
	public void testAdd() {
//		LogicClass l1=new LogicClass();
		
		Integer originaloutput=lc.add(7, 3);
		
		Integer expectedoutput=10;
		
		assertEquals(expectedoutput,originaloutput);
	}
	
	@Test
	public void testMultiply() {
		
//		LogicClass l2=new LogicClass();
		
		Integer oop=lc.multiply(5, 5);
		Integer eop=25;
		
		assertEquals(eop,oop);
	}
	
}

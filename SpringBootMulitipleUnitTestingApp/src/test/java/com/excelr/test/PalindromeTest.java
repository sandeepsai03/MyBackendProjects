package com.excelr.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.excelr.logic.PalindromeLogic;

public class PalindromeTest {

	@ParameterizedTest ///for multiple values
	@ValueSource(strings= {"madam","radar","dad","mom","sandeep"})
	public void testPalindrome(String s)
	{
	    PalindromeLogic p1=new PalindromeLogic();
	    boolean actualoutput=p1.isPalindrome(s);
	    assertTrue(actualoutput);
	}
	
}

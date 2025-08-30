package com.excelr.logic;

public class PalindromeLogic {

	public boolean isPalindrome(String s) {
		
		String res="";
		for(int i=s.length()-1;i>=0;i--) {
			res=res+s.charAt(i);
		}
		if(res.equals(s)) {
			return true;
		}
		else {
			return false;
		}
	}
}

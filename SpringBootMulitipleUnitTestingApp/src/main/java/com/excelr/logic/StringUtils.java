package com.excelr.logic;

public class StringUtils {

	public static Integer convertToInt(String str) {
		
		if(str==null || str.length()==0) {
			throw new IllegalArgumentException("string must not be null or empty");
		}
		return Integer.valueOf(str);
	}
	
}

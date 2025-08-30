package com.excelr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.client.FirstDetailsApiClient;

@RestController
public class SecondRestController {

	@Autowired
	private FirstDetailsApiClient fp;
	
	@GetMapping("/second")
	public String SecondMsg() {
		
		String s2="welcome to second rest api";
		
		String s3=fp.invokeMethodFromFirst();
		
		return s2+s3;
}
}
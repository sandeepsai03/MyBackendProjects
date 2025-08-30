package com.excelr.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	private Logger logger=LoggerFactory.getLogger(SampleRestController.class);
	
	@GetMapping("/excelr")
	public ResponseEntity<String> getExcelrMsg(){
		
		try {
			int i=12/0;
		}
		catch(ArithmeticException e) {
			logger.error("Exception occured "+e.getMessage());
			throw e;
		}
		String s1="wake up good afternoon...";
		return new ResponseEntity<String>(s1,HttpStatus.OK);
	}
}

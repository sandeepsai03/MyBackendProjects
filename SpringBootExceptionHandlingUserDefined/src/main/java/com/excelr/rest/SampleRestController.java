package com.excelr.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.exception.NoDataFoundException;

@RestController
public class SampleRestController {

	
	@GetMapping("/price/{isbn}")
	public ResponseEntity<String> getBookPrice(@PathVariable String isbn){
		
	String msg="";
	if(isbn.equals("sai123")) {
		msg="Book price is 200 valid nice book";
	}
	else {
		throw new NoDataFoundException("Invalid Isbn.....Please correct it");
	}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}

package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@GetMapping("/contact")
	public ResponseEntity<String> contactMsg(){
		String s1="welcome to contact page......excelr no problem no complicated and risk";
		return new ResponseEntity<String>(s1,HttpStatus.OK);
	}
}

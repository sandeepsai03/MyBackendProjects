package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@GetMapping("/sample")
	public ResponseEntity<String> getSampleMsg(){
		
		String s1="welcome to actuators";
		return new ResponseEntity<String> (s1,HttpStatus.OK);
	}
}

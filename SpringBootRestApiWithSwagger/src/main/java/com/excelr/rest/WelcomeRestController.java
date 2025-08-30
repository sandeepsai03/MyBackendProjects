package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	//normal api
	@GetMapping("/wish")
    public ResponseEntity<String> getWishMsg(){
		
		String s1="welcome to excelr and how are you....";
		return new ResponseEntity<>(s1,HttpStatus.OK);
	}
	
	//pathparam
	  @GetMapping("/path/{name}")
       public ResponseEntity<String> deleteBook(@PathVariable String name){
		
		String s2="Hello how are you from path param"+name;
		return new ResponseEntity<>(s2,HttpStatus.OK);
	}
}

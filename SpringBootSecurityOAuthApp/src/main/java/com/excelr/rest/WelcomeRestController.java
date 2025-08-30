package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	 @GetMapping("/login")
	    public ResponseEntity<String> welcomeMsg() {
	        String s1 = "Good afternoon how are you......";
	        return new ResponseEntity<>(s1, HttpStatus.OK);
	    }
}

package com.excelr.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	
	//normal api
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg(){
		
		String res="welcome to first rest api...";
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
	
	//pathparam api
	@GetMapping("/welcome/{name}")
	public ResponseEntity<String> getPathParamMsg(@PathVariable("name") String name){
		
		String res=name+" welcome to Excelr";
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	//Queryparam api
	@GetMapping("/match")
	public ResponseEntity<String> getQueryParam(@RequestParam(value="name",required=true)String name){
		String res=name+"How did you enjoy last match";
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
}

package com.excelr.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

	@GetMapping("/first")
	  public String getMsg() {
		return "welcome to first rest api app";
		  
	  }
	
}

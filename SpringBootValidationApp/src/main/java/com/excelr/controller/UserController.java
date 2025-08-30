package com.excelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.excelr.entity.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/data")
	public String getForm(Model model) {
		
		User uo=new User();
		model.addAttribute("user",uo);
		return "index";
		
	}
	
	/// @Valid User user:This tells Spring to bind the incoming form data to a User object and validate it using the annotations defined in the User class.
	
	/// BindingResult result:This holds the result of the validation performed on the User object.
	@PostMapping("/register")
	public String handleRegister(@Valid User user,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			return "index";
		}
		
		model.addAttribute("msg","your registration successful");
		return "success";
		
	}
	
}

package com.excelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	///Normal method
	@GetMapping("/welcome")
	@ResponseBody
	public String getWelcomeMsg() {
		return "welcome to spring web mvc app....";
	}
	
	///model
	@GetMapping("/greet")
	public String getWishMsg(Model model) {
		model.addAttribute("msg","Good afternoon how are you");
		return "firstoutput";// it is response file or output file name
	}
	
	///ModelAndView
	@GetMapping("/bye")
	public ModelAndView getByeMsg() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("res","Good bye please study");
		mav.setViewName("secondoutput");// it is response file or output file name
		return mav;
	}
}

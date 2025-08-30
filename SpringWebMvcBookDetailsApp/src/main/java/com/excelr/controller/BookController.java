package com.excelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.excelr.entity.Book;

@Controller
public class BookController {

	@GetMapping("/bform")
	public String getBookForm(Model model) {
		Book b1=new Book();
		
		model.addAttribute("book",b1);
		return "bookform";//it is output or response file name
	}
	
	@PostMapping("/handlebook")
	public String handleBook(Book b,Model model) {
		model.addAttribute("msg","Book details saved successfully");
		return "bookdata";
	}
}

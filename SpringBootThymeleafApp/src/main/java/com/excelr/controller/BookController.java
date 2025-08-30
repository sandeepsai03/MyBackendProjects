package com.excelr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.excelr.SpringBootThymeleafAppApplication;
import com.excelr.entity.Book;

@Controller
public class BookController {

   

	@GetMapping("/book")
	public String getBookForm(Model model) {
		Book b1=new Book();
		model.addAttribute("book",b1);
		return "bookform";
	}
	
	@PostMapping("/bookdata")
	public String handleBook(Book book,Model model) {
		System.out.println(book);
		model.addAttribute("msg","Data saved successfully");
		return "outputdata";
	}
}

package com.excelr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Book;

@RestController
public class BookRestController {

  

	//to add book details in the post man app in body section
	@PostMapping("/save")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		
		System.out.println(book);
		return new ResponseEntity<>(book,HttpStatus.CREATED);
	}
	
	//to update book details
	@PutMapping("/update")
   public ResponseEntity<Book> updateBook(@RequestBody Book book){
		
		System.out.println(book);
		return new ResponseEntity<>(book,HttpStatus.OK);
	} 
	
	//retrive a book details based on id
	@GetMapping("/get/{id}")
   public ResponseEntity<Book> getBook(@PathVariable Integer id){
		
		Book b1=new Book();
		b1.setId(401);
		b1.setName("java");
		b1.setPrice(200.12);
		return new ResponseEntity<>(b1,HttpStatus.OK);
	}
	
	//delete a book based on id
	@DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteBook(@PathVariable Integer id){
		
		String msg="Book is deleted";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}

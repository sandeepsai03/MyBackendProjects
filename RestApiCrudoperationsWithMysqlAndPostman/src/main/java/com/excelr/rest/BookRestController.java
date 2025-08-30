package com.excelr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Book;
import com.excelr.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService; 
	
	//add a new book
	@PostMapping("/booksRecord")
	public ResponseEntity<String> addBook(@RequestBody Book book){
		String msg=bookService.upsertBook(book);
		return ResponseEntity.status(201).body(msg);
	}
	
	//update an existing book
	@PutMapping("/updateRecord")
	public ResponseEntity<String> updateBook(@RequestBody Book book){
		String msg=bookService.upsertBook(book);
		return ResponseEntity.ok(msg);
	}
	
	//Get all books
	@GetMapping("/retriveRecords")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books=bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}
	
	//Delete a book by id
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId){
		String msg=bookService.deleteBook(bookId);
		return ResponseEntity.ok(msg);
	}
}

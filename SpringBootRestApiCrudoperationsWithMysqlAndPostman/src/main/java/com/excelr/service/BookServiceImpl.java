package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Book;
import com.excelr.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	///method to insert or update a book.
	@Override
	public String upsertBook(Book book) {
		//If the book id is null,it's a new book,so insert it
		if(book.getBookId()==null) {
			Book savedBook =bookRepository.save(book);
			return "Book inserted with ID: "+savedBook.getBookId();
		}
		//otherwise,it's an update
		else {
			Book savedBook =bookRepository.save(book);
			return "Book updated with ID: "+savedBook.getBookId();
		}
	}
	
    ///Method to get all books from the database
	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	///method to delete a book id
	@Override
	public String deleteBook(Integer bookId) {
		//Check if the book exists in the repository
		if(bookRepository.existsById(bookId)) {
			bookRepository.deleteById(bookId);
			return "Book deleted with ID: "+bookId;
		}
		return "Book not found with ID: "+bookId;
	}

}

package com.excelr.service;

import java.util.List;

import com.excelr.entity.Book;

public interface BookService {

     String	upsertBook(Book book);//public and abstract keywords bydefault comes in runtime
  
     List<Book> getAllBooks();
     
     String  deleteBook(Integer bookId);
}

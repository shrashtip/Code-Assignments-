package com.greatlearning.bookstore.bookstoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.bookstore.bookstoremanagement.entities.Book;
import com.greatlearning.bookstore.bookstoremanagement.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService service;

	
   @GetMapping(value = "/books" )
   public List<Book> getBooks() {
	   return service.getAllBooks();
   }
   
   @PostMapping(value = "/book" )
   public Book saveBook(@RequestBody Book book) {
	    return   service.saveBook(book);
   }
}

package com.greatlearning.bookstore.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.bookstore.bookstoremanagement.entities.Book;
import com.greatlearning.bookstore.bookstoremanagement.repositories.BookRepository;

@Service
public class BookService {
       
	@Autowired
	private BookRepository repositery;
	
	public List<Book> getAllBooks() {
		return repositery.findAll();
	}
	
	public Book saveBook( Book book) {
		return repositery.save(book);
	}
}

package com.greatlearning.bookstore.bookstoremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.bookstore.bookstoremanagement.entities.Cart;
import com.greatlearning.bookstore.bookstoremanagement.exceptions.BookNotFoundException;
import com.greatlearning.bookstore.bookstoremanagement.service.CartService;


@RestController
public class CartController {

	@Autowired
	private CartService service;
	
	
	@GetMapping(value = "/cart")
	public List<Cart> getAllBooksInCart(){
		return service.getAllBooks();
	}
	

	@PostMapping(value = "/cart/{id}")
	public Cart saveBookToCart(@PathVariable int id) throws BookNotFoundException{
		System.out.print(id);
		return service.saveBookToCart(id);
	}
}

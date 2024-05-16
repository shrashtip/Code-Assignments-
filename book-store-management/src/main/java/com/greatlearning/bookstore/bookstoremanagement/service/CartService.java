package com.greatlearning.bookstore.bookstoremanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.bookstore.bookstoremanagement.entities.Book;
import com.greatlearning.bookstore.bookstoremanagement.entities.Cart;
import com.greatlearning.bookstore.bookstoremanagement.exceptions.BookNotFoundException;
import com.greatlearning.bookstore.bookstoremanagement.repositories.BookRepository;
import com.greatlearning.bookstore.bookstoremanagement.repositories.CartRepository;

@Service
public class CartService {
       
	@Autowired
	private CartRepository cartRepositery;
	
	 
    @Autowired
	private BookRepository bookRepository;
	
	public List<Cart> getAllBooks() {
		return cartRepositery.findAll();
	}
	
//	int iD, String title, String author, String genre, double price, int qty
	
	public Cart saveBookToCart(int id) throws BookNotFoundException  {
		try {
			  Book book =bookRepository.findById(id).get();
			   Cart cart = new Cart( 0 , book.getTitle(), book.getAuthor(), book.getGenre() , book.getPrice() , book.getQty() );
			   return cartRepositery.save(cart);
		}catch(Exception e) {
			throw new BookNotFoundException("Book not found !!");
		}
	 
	}
}

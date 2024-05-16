package com.greatlearning.bookstore.bookstoremanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bookstore.bookstoremanagement.entities.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {


}

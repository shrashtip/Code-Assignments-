package com.greatlearning.bookstore.bookstoremanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bookstore.bookstoremanagement.entities.Cart;

public interface CartRepository  extends JpaRepository<Cart, Integer> {

}

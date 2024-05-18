package com.greatlearning.bookstore.bookstoremanagement.exceptions;



public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Movie not found with id: " + id);
    }
}
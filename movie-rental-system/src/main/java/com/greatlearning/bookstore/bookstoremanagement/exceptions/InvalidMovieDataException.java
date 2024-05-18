package com.greatlearning.bookstore.bookstoremanagement.exceptions;


public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
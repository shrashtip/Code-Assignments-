package com.greatlearning.bookstore.bookstoremanagement.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bookstore.bookstoremanagement.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

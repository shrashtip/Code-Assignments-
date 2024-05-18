package com.greatlearning.bookstore.bookstoremanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.bookstore.bookstoremanagement.entities.Movie;
import com.greatlearning.bookstore.bookstoremanagement.exceptions.InvalidMovieDataException;
import com.greatlearning.bookstore.bookstoremanagement.exceptions.MovieNotFoundException;
import com.greatlearning.bookstore.bookstoremanagement.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }

    public Movie save(Movie movie) {
        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new InvalidMovieDataException("Movie title cannot be empty");
        }
        return movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
    }
}

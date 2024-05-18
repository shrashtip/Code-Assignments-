package com.greatlearning.bookstore.bookstoremanagement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.bookstore.bookstoremanagement.entities.Movie;
import com.greatlearning.bookstore.bookstoremanagement.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // GET /movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }

    // GET /movies/{id}
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    // POST /movies
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    // PUT /movies/{id}
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Movie movie = movieService.findById(id);

        movie.setTitle(movieDetails.getTitle());
        movie.setDirector(movieDetails.getDirector());
        movie.setGenre(movieDetails.getGenre());
        movie.setReleaseYear(movieDetails.getReleaseYear());

        return movieService.save(movie);
    }

    // DELETE /movies/{id}
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
    }
}

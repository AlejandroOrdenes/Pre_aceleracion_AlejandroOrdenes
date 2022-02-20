package com.alkemy.api.controllers;

import com.alkemy.api.dto.GenreDTO;
import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

/*    @GetMapping
    public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
        MovieDTO movie = movieService.getById(id);
        return ResponseEntity.ok().body(movie);
    }*/

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAll() {
        List<MovieBasicDTO> movies = movieService.getAllmovies();
        return ResponseEntity.ok().body(movies);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO savedMovie = this.movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO movie, @PathVariable Long id){
        MovieDTO updateMovie = this.movieService.update(id, movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

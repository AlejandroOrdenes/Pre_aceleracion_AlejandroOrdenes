package com.alkemy.api.controllers;


import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAll() {
        List<MovieBasicDTO> movies = movieService.getAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = movieService.getById(id);
        return ResponseEntity.ok().body(movie);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long genreId,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<MovieDTO> movies = movieService.getByFilters(title, genreId, order);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save( @Valid @RequestBody MovieDTO movie){
        MovieDTO savedMovie = this.movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update( @Valid @RequestBody MovieDTO movie, @PathVariable Long id){
        MovieDTO updateMovie = this.movieService.update(id, movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/character/{idCharacter}")
    public ResponseEntity<Void> addCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        this.movieService.addCharacter(id, idCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/character/{idCharacter}")
    public ResponseEntity<Void> removeCharacter(@PathVariable Long id, @PathVariable Long idCharacter) {
        this.movieService.removeCharacter(id, idCharacter);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

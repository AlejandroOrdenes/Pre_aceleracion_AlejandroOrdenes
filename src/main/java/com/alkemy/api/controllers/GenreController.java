package com.alkemy.api.controllers;

import com.alkemy.api.dto.GenreDTO;
import com.alkemy.api.entity.GenreEntity;
import com.alkemy.api.service.GenreService;
import com.alkemy.api.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> save(@Valid @RequestBody GenreDTO genre){
        GenreDTO savedGenre = this.genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre);
    }
}

package com.alkemy.api.controllers;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAll() {
        List<CharacterBasicDTO> characters = characterService.getAllCharacters();

        return ResponseEntity.ok().body(characters);
    }


    @PostMapping
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character){
        CharacterDTO savedCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO character, @PathVariable Long id){
        CharacterDTO updateCharacter = characterService.update(id, character);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie) {
        this.characterService.addMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/movie/{idMovie}")
    public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable Long idMovie) {
        this.characterService.removeMovie(id, idMovie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

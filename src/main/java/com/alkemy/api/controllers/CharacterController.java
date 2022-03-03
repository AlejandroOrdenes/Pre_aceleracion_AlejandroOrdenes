package com.alkemy.api.controllers;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> getAll() {
        List<CharacterBasicDTO> characters = characterService.getAll();

        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
        CharacterDTO dto = characterService.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/filters")
    public ResponseEntity<List<CharacterDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue ="0") int age,
            @RequestParam(defaultValue = "0") int weight,
            @RequestParam(required = false) List<Long> movies
    ) {
        List<CharacterDTO> characters = characterService.getByFilters(name, age, weight, movies);
        return ResponseEntity.ok(characters);

    }


    @PostMapping
    public ResponseEntity<CharacterDTO> save(@Valid @RequestBody CharacterDTO character){
        CharacterDTO savedCharacter = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@Valid @RequestBody CharacterDTO character, @PathVariable Long id){
        CharacterDTO updateCharacter = characterService.update(id, character);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateCharacter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

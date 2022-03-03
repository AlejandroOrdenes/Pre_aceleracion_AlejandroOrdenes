package com.alkemy.api.service;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieDTO;

import java.util.List;

public interface CharacterService {
    CharacterDTO save(CharacterDTO character);

    List<CharacterBasicDTO> getAll();

    void delete(Long id);

    CharacterDTO update(Long id, CharacterDTO character);

    CharacterDTO getById(Long idCharacter);

    List<CharacterDTO> getByFilters(String name, int age, int weight, List<Long> movies);
}

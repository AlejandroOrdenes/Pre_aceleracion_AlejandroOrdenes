package com.alkemy.api.service;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    CharacterDTO save(CharacterDTO character);

    List<CharacterBasicDTO> getAllCharacters();

    void delete(Long id);

    CharacterDTO update(Long id, CharacterDTO character);

    CharacterDTO getCharacterById(Long idCharacter);

    List<CharacterDTO> getByFilters(String name, int age, float weight, Long movies);
}

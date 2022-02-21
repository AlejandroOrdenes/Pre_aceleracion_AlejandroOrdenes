package com.alkemy.api.service;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.entity.CharacterEntity;

import java.util.List;

public interface CharacterService {
    CharacterDTO save(CharacterDTO character);

    List<CharacterBasicDTO> getAllCharacters();

    void delete(Long id);

    CharacterDTO update(Long id, CharacterDTO character);

    void addMovie(Long id, Long idMovie);

    void removeMovie(Long id, Long idMovie);

    CharacterEntity getCharacterById(Long idCharacter);
}

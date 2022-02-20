package com.alkemy.api.service.impl;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.GenreDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.GenreEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.mapper.CharacterMapper;
import com.alkemy.api.repository.CharacterRepository;
import com.alkemy.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    CharacterRepository characterRepository;

    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity entitySave = characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySave, false);
        return result;
    }

    @Override
    public List<CharacterBasicDTO> getAllCharacters() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterBasicDTO> result = characterMapper.characterEntityBasicList2DtoBasicList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        characterRepository.deleteById(id);
    }

    ;
}

package com.alkemy.api.service.impl;

import com.alkemy.api.dto.*;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.exception.ParamNotFound;
import com.alkemy.api.mapper.CharacterMapper;
import com.alkemy.api.repository.CharacterRepository;
import com.alkemy.api.repository.specification.CharacterSpecification;
import com.alkemy.api.service.CharacterService;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterSpecification characterSpecification;

    @Autowired
    private MovieService movieService;



    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto, true);
        CharacterEntity entitySave = characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySave, true);

        return result;
    }

    @Override
    public List<CharacterBasicDTO> getAll() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterBasicDTO> result = characterMapper.characterEntityBasicList2DtoBasicList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Character Id Not found");
        }
        characterRepository.deleteById(id);

    }

    @Override
    public CharacterDTO update(Long id, CharacterDTO character) {
        Optional<CharacterEntity> entityOpt = characterRepository.findById(id);
        if(entityOpt.isEmpty()) {
            throw new Error("Character Id Not Found");
        }
        CharacterEntity newEntity = characterMapper.updateData(entityOpt.get(), character);
        characterRepository.save(newEntity);
        CharacterDTO dto = characterMapper.characterEntity2DTO(newEntity, true);

        return dto;
    }



    @Override
    public CharacterDTO getById(Long idCharacter) {
        Optional<CharacterEntity> entityOpt = characterRepository.findById(idCharacter);
        CharacterEntity entityGet = entityOpt.get();
        CharacterDTO dto = characterMapper.characterEntity2DTO(entityGet, true);
        return dto;
    }

    public List<CharacterDTO> getByFilters(String name, int age, int weight, List<Long> movies) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies);
        List<CharacterEntity> entities = this.characterRepository.findAll(this.characterSpecification.getByFilters(filtersDTO));
        List<CharacterDTO> dtos = characterMapper.characterEntityList2DTOList(entities, true);
        return dtos;
    }


}

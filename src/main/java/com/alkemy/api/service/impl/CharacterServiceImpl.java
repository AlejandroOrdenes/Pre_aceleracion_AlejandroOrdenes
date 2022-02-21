package com.alkemy.api.service.impl;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.mapper.CharacterMapper;
import com.alkemy.api.repository.CharacterRepository;
import com.alkemy.api.service.CharacterService;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    MovieService movieService;


    public CharacterDTO save(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto, true);
        CharacterEntity entitySave = characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySave, true);

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

    @Override
    public CharacterDTO update(Long id, CharacterDTO character) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if( !entity.isPresent() ) {
            throw new Error("Character Id Not Found");
        }
        save(character);

        return character;
    }


    public void addMovie(Long id, Long idMovie) {
        CharacterEntity entity = this.characterRepository.getById(id);
        entity.getMovies().size();
        MovieEntity movieEntity = this.movieService.getMovieById(idMovie);
        entity.addMovie(movieEntity);
        this.characterRepository.save(entity);
    }

    public void removeMovie(Long id, Long idMovie) {
        CharacterEntity entity = this.characterRepository.getById(id);
        entity.getMovies().size();
        MovieEntity movieEntity = this.movieService.getMovieById(idMovie);
        entity.removeMovie(movieEntity);
        this.characterRepository.save(entity);
    }

    @Override
    public CharacterEntity getCharacterById(Long idCharacter) {
        Optional<CharacterEntity> entityOpt = characterRepository.findById(idCharacter);
        CharacterEntity entity = entityOpt.get();
        return entity;
    }

}

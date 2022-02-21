package com.alkemy.api.mapper;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.service.CharacterService;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    MovieService movieService;

    @Autowired
    CharacterService characterService;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto, boolean loadMovies) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(dto.getId());
        characterEntity.setImage(dto.getImage());
        characterEntity.setAge(dto.getAge());
        characterEntity.setName(dto.getName());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setWeight(dto.getWeight());

        if (loadMovies) {
            List<MovieEntity> entity = movieMapper.movieDTOList2EntityList(dto.getMovies(),false);
            characterEntity.setMovies(entity);
        }

        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies) {
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setAge(entity.getAge());
        dto.setName(entity.getName());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());

        if (loadMovies) {
            List<MovieDTO> moviesDto = this.movieMapper.movieEntityList2DTOList(entity.getMovies(),false);
            dto.setMovies(moviesDto);
        }
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovies) {
        List<CharacterDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtos.add(characterEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }

    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtos, boolean loadMovies) {
        List<CharacterEntity> entity = new ArrayList<>();
        for (CharacterDTO dto : dtos){
            entity.add(characterDTO2Entity(dto, loadMovies));
        }
        return entity;
    }

    public CharacterBasicDTO characterEntity2DtoBasic(CharacterEntity entity) {
        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }

    public List<CharacterBasicDTO> characterEntityBasicList2DtoBasicList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtos.add(characterEntity2DtoBasic(entity));
        }


        return dtos;
    }
}

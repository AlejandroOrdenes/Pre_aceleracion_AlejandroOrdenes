package com.alkemy.api.mapper;

import com.alkemy.api.dto.CharacterBasicDTO;
import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setId(dto.getId());
        characterEntity.setImage(dto.getImage());
        characterEntity.setAge(dto.getAge());
        characterEntity.setName(dto.getName());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setWeight(dto.getWeight());

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
            List<MovieDTO> moviesDto = movieMapper.movieEntityList2DTOList(entity.getMovies(),false);
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

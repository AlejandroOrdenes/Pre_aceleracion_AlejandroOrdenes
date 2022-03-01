package com.alkemy.api.mapper;

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
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    public MovieEntity movieDTO2Entity(MovieDTO dto, boolean loadCharacters) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setImage(dto.getImage());
        movieEntity.setRating(dto.getRating());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setGenreId(dto.getGenreId());
        if (loadCharacters) {
            List<CharacterEntity> entity = characterMapper.characterDTOList2EntityList(dto.getCharacters(),true);
            movieEntity.setCharacters(entity);
        }

        return movieEntity;
    }

    public MovieDTO movieEntity2Dto(MovieEntity entity, boolean loadCharacter) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setRating(entity.getRating());
        dto.setCreationDate(entity.getCreationDate());
        dto.setGenreId(entity.getGenreId());
        if(loadCharacter) {
            List<CharacterDTO> characterDTOS = characterMapper.characterEntityList2DTOList(entity.getCharacters(), true);
            dto.setCharacters(characterDTOS);
        }

        return dto;
    }
    public MovieBasicDTO movieEntity2DtoBasic(MovieEntity entity) {
        MovieBasicDTO dto = new MovieBasicDTO();
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setCreationDate(entity.getCreationDate());

        return dto;
    }

    public List<MovieBasicDTO> movieEntityBasicList2DtoBasicList(List<MovieEntity> entities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(movieEntity2DtoBasic(entity));
        }
        return dtos;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(movieEntity2Dto(entity, true));
        }
        return dtos;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtos, boolean loadCharacters) {
        List<MovieEntity> entity = new ArrayList<>();
        for (MovieDTO dto : dtos){
            entity.add(movieDTO2Entity(dto, true));
        }
        return entity;
    }

    public MovieEntity updateData(MovieEntity movieEntity, MovieDTO movie) {
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setImage(movie.getImage());
        movieEntity.setRating(movie.getRating());
        movieEntity.setCreationDate(movie.getCreationDate());
        return movieEntity;
    }
}

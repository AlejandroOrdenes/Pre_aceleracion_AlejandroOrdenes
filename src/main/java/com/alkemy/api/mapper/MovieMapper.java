package com.alkemy.api.mapper;

import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    public static MovieEntity movieDTO2Entity(MovieDTO dto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(dto.getTitle());
        movieEntity.setImage(dto.getImage());
        movieEntity.setRating(dto.getRating());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setGenreId(dto.getGenreId());

        return movieEntity;
    }

    public static MovieDTO movieEntity2Dto(MovieEntity entity) {
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setTitle(dto.getTitle());
        dto.setImage(entity.getImage());
        dto.setRating(entity.getRating());
        dto.setCreationDate(entity.getCreationDate());
        dto.setGenreId(entity.getGenreId());

        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities) {
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities){
            dtos.add(movieEntity2Dto(entity));
        }
        return dtos;
    }
}

package com.alkemy.api.service;

import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.MovieEntity;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    void delete(Long id);

    MovieDTO update(Long id, MovieDTO movie);

    List<MovieDTO> getAllmovies();

    MovieEntity getMovieById(Long idMovie);

    void addCharacter(Long id, Long idCharacter);

    void removeCharacter(Long id, Long idCharacter);

//    List<MovieDTO> getByFilters(String name, Long genre, String order);
}

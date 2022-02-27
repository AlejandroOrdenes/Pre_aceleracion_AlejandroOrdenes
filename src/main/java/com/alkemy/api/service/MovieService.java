package com.alkemy.api.service;

import com.alkemy.api.dto.MovieDTO;


import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    void delete(Long id);

    MovieDTO update(Long id, MovieDTO movie);

    List<MovieDTO> getAllmovies();

    MovieDTO getMovieById(Long idMovie);

    void addCharacter(Long id, Long idCharacter);

    void removeCharacter(Long id, Long idCharacter);

    List<MovieDTO> getByFilters(String title, Long genre, String order);
}

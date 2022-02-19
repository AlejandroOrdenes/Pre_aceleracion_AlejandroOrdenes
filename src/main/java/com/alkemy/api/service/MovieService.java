package com.alkemy.api.service;

import com.alkemy.api.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> getAllmovies();

    void delete(Long id);
}

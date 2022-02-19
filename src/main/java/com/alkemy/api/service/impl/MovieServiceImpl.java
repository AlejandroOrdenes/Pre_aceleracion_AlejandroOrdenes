package com.alkemy.api.service.impl;

import com.alkemy.api.dto.GenreDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.mapper.MovieMapper;
import com.alkemy.api.repository.MovieRepository;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = MovieMapper.movieDTO2Entity(dto);
        MovieEntity entitySave = movieRepository.save(entity);
        MovieDTO result = MovieMapper.movieEntity2Dto(entitySave);
        return result;
    }

    @Override
    public List<MovieDTO> getAllmovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

}

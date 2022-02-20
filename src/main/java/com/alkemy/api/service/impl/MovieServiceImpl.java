package com.alkemy.api.service.impl;

import com.alkemy.api.dto.MovieBasicDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.mapper.MovieMapper;
import com.alkemy.api.repository.MovieRepository;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySave = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2Dto(entitySave, true);
        return result;
    }

    @Override
    public List<MovieBasicDTO> getAllmovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieBasicDTO> result = movieMapper.movieEntityBasicList2DtoBasicList(entities);
        return result;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movie) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if( !entity.isPresent() ) {
            throw new Error("Movie Id Not Found");
        }
        save(movie);

        return movie;
    }

/*    @Override
    public MovieDTO getById(Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if( !entity.isPresent() ){
            throw new Error("Movie Id Not Found");
        }

        return ;
    }*/


}

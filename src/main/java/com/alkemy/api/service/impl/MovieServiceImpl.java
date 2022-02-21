package com.alkemy.api.service.impl;

import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.dto.MovieFiltersDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.mapper.MovieMapper;
import com.alkemy.api.repository.MovieRepository;
import com.alkemy.api.repository.specification.MovieSpecifications;
import com.alkemy.api.service.CharacterService;
import com.alkemy.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieSpecifications movieSpecifications;
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    CharacterService characterService;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto, true);
        MovieEntity entitySave = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2Dto(entitySave, true);
        return result;
    }

    @Override
    public List<MovieDTO> getAllmovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, true);
        return result;
    }

    @Override
    public MovieEntity getMovieById(Long idMovie) {
        Optional<MovieEntity> entityOpt = movieRepository.findById(idMovie);
        MovieEntity entity = entityOpt.get();
        return entity;
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

    @Override
    public void addCharacter(Long id, Long idCharacter) {
        MovieEntity entity = this.movieRepository.getById(id);
        entity.getCharacters().size();
        CharacterEntity characterEntity = this.characterService.getCharacterById(idCharacter);
        entity.addCharacter(characterEntity);
        this.movieRepository.save(entity);
    }

    @Override
    public void removeCharacter(Long id, Long idCharacter) {
        MovieEntity entity = this.movieRepository.getById(id);
        entity.getCharacters().size();
        CharacterEntity characterEntity = this.characterService.getCharacterById(idCharacter);
        entity.removeCharacter(characterEntity);
        this.movieRepository.save(entity);
    }

/*    @Override
    public List<MovieDTO> getByFilters(String name, Long genre, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name, genre, order);
        List<MovieEntity> entities = this.movieRepository.findAll(this.movieSpecifications.getByFilters(filtersDTO));
        return null;
    }*/


}

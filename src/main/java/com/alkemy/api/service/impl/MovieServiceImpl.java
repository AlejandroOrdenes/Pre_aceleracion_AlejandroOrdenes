package com.alkemy.api.service.impl;

import com.alkemy.api.dto.CharacterDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.dto.MovieFiltersDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import com.alkemy.api.exception.ParamNotFound;
import com.alkemy.api.mapper.MovieMapper;
import com.alkemy.api.repository.CharacterRepository;
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
    MovieService movieService;

    @Autowired
    CharacterService characterService;

    @Autowired
    CharacterRepository characterRepository;

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
    public MovieDTO getMovieById(Long idMovie) {
        Optional<MovieEntity> entity = movieRepository.findById(idMovie);
        MovieEntity entityGet = entity.get();
        MovieDTO movieDTO = movieMapper.movieEntity2Dto(entityGet, true);
        return movieDTO;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movie) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if( !entity.isPresent() ) {
            throw new ParamNotFound("Movie Id Not Found");
        }
        MovieEntity newEntity = movieMapper.updateData(entity.get(), movie);
        movieRepository.save(newEntity);
        MovieDTO dto = movieMapper.movieEntity2Dto(newEntity, true);
        return dto;
    }

    @Override
    public void addCharacter(Long id, Long idCharacter) {
        MovieEntity entity = movieRepository.getById(id);
        entity.getCharacters().size();
        CharacterEntity characterEntity = characterRepository.getById(idCharacter);
        entity.addCharacter(characterEntity);
        characterEntity.addMovie(entity);
        this.movieRepository.save(entity);
    }

    @Override
    public void removeCharacter(Long id, Long idCharacter) {
        MovieEntity entity = this.movieRepository.getById(id);
        entity.getCharacters().size();
        CharacterEntity characterEntity = characterRepository.getById(idCharacter);
        entity.removeCharacter(characterEntity);
        this.movieRepository.save(entity);
    }

    public List<MovieDTO> getByFilters(String title, Long genreId, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, genreId, order);
        List<MovieEntity> entities = this.movieRepository.findAll(this.movieSpecifications.getByFilters(filtersDTO));
        List<MovieDTO> dtos = movieMapper.movieEntityList2DTOList(entities, true);
        return dtos;
    }




}

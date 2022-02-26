package com.alkemy.api.service.impl;

import com.alkemy.api.dto.GenreDTO;
import com.alkemy.api.entity.GenreEntity;
import com.alkemy.api.mapper.GenreMapper;
import com.alkemy.api.repository.GenreRepository;
import com.alkemy.api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO dto) {
        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySave = genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2Dto(entitySave);
        return result;
    }

}

package com.alkemy.api.dto;

import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.GenreEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;

    private String title;

    private String image;

    private LocalDate creationDate;

    private int rating;

    private Long genreId;

}

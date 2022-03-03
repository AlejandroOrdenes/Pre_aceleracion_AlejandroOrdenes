package com.alkemy.api.dto;

import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.GenreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CharacterDTO> characters;

}

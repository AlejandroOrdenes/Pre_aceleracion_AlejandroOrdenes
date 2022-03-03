package com.alkemy.api.dto;

import com.alkemy.api.entity.MovieEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private Long id;

    private String image;

    private String name;

    private int age;

    private float weight;

    private String history;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MovieDTO> movies;

}

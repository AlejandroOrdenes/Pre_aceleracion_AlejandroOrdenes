package com.alkemy.api.dto;

import com.alkemy.api.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterFiltersDTO {
    private String name;
    private int age;
    private float weight;
    private Long movies;

    public CharacterFiltersDTO(String name, int age, float weight, Long movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }

}

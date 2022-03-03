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
    private int weight;
    private List<Long> movies;

    public CharacterFiltersDTO(String name, int age, int weight, List<Long> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }
}

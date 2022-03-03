package com.alkemy.api.entity;

import com.alkemy.api.dto.MovieDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "characterEntity")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String image;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private float weight;

    private String history;

    @ManyToMany(fetch = FetchType.LAZY ,mappedBy = "characters", cascade = CascadeType.MERGE)
    private List<MovieEntity> movies = new ArrayList<>();

    public void addMovie(MovieEntity movie) {
        movies.add(movie);
    }

    public void removeMovie(MovieEntity movie) {
        movies.remove(movie);
    }

}


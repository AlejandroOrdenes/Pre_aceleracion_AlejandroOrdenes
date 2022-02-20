package com.alkemy.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String name;

    private int age;

    private float weight;

    private String history;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.MERGE)
    private List<MovieEntity> movies = new ArrayList<>();
}

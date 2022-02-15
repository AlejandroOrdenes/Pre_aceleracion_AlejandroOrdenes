package com.alkemy.api.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    private int rating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
    fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_Id"))
    private Set<CharacterEntity> characters = new HashSet<>();

}

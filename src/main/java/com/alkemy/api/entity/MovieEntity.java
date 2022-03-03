package com.alkemy.api.entity;


import com.alkemy.api.dto.CharacterDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false ")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @NotNull
    private String title;

    @NotNull
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Range(min = 1, max = 5)
    @NotNull
    private int rating;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "genre_id",insertable = false, updatable = false)
    private GenreEntity genre;

    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_Id"))
    private List<CharacterEntity> characters = new ArrayList<>();

    public void addCharacter(CharacterEntity character) {
        characters.add(character);
        character.getMovies().add(this);
    }

    public void removeCharacter(CharacterEntity character) {
        characters.remove(character);
        character.getMovies().remove(this);
    }
}

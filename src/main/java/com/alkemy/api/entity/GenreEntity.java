package com.alkemy.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String iamge;

    private String name;
}

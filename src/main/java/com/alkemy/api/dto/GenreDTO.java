package com.alkemy.api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class GenreDTO {
    private Long id;

    private String image;

    private String name;
}

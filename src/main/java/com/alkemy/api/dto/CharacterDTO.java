package com.alkemy.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private Long id;

    private String imagen;

    private String name;

    private int age;

    private float weight;

    private String history;
}

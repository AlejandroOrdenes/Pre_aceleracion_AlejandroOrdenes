package com.alkemy.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieBasicDTO {
    private String title;
    private String image;
    private LocalDate creationDate;


}

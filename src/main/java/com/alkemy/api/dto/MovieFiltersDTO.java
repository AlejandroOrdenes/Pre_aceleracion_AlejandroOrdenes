package com.alkemy.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieFiltersDTO {
    private String title;
    private Long genreId;
    private String order;

    public MovieFiltersDTO(String title, Long genreId, String order) {
        this.title = title;
        this.genreId = genreId;
        this.order = order;
    }

    public boolean isASC() { return this.order.compareToIgnoreCase("ASC") == 0; }
    public boolean isDESC() { return this.order.compareToIgnoreCase("DESC") == 0; }
}

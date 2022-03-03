
package com.alkemy.api.repository.specification;


import com.alkemy.api.dto.MovieFiltersDTO;
import com.alkemy.api.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public class MovieSpecifications {
  public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO) {
      return (root, query, criteriaBuilder) -> {

          List<Predicate> predicates = new ArrayList<>();

          if (StringUtils.hasLength(filtersDTO.getTitle())) {
              predicates.add(
                      criteriaBuilder.like(
                              criteriaBuilder.lower(root.get("title")),
                              "%" + filtersDTO.getTitle().toLowerCase() + "%"));
          }

          if (filtersDTO.getGenreId() != null) {
              predicates.add(
                      criteriaBuilder.like(root.get("genreId").as(String.class),
                              "%" + filtersDTO.getGenreId() + "%")
              );
          }

          String orderByField = "creationDate";
          query.orderBy(
                  filtersDTO.isASC() ?
                          criteriaBuilder.asc(root.get(orderByField)) :
                          criteriaBuilder.desc(root.get(orderByField))
          );

          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      };

  }
}


package com.alkemy.api.repository.specification;


import com.alkemy.api.dto.MovieFiltersDTO;
import com.alkemy.api.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class MovieSpecifications {
/*    public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }
        }
    }*/

}


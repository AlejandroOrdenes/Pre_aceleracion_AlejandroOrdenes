package com.alkemy.api.repository.specification;

import com.alkemy.api.dto.CharacterFiltersDTO;
import com.alkemy.api.entity.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSpecification {
    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"));
            }

            if (filtersDTO.getAge() != 0) {
                predicates.add(
                        criteriaBuilder.like(root.get("age").as(String.class),
                                "%" + filtersDTO.getAge() + "%")
                );
            }

            if (filtersDTO.getWeight() != 0) {
                predicates.add(
                        criteriaBuilder.like(root.get("weight").as(String.class),
                                "%" + filtersDTO.getWeight() + "%")
                );
            }

/*            if (filtersDTO.getMovies() != null) {
                predicates.add(
                        criteriaBuilder.like(root.get("movies").as(String.class),
                                "%" + filtersDTO.getMovies() + "%")
                );
            }*/


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}

package com.alkemy.api.repository.specification;

import com.alkemy.api.dto.CharacterFiltersDTO;
import com.alkemy.api.dto.MovieDTO;
import com.alkemy.api.entity.CharacterEntity;
import com.alkemy.api.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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

            if (!CollectionUtils.isEmpty(filtersDTO.getMovies())) {
                Join<MovieEntity, CharacterEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}

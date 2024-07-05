package com.rosana.store.repository;

import com.rosana.store.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

        public static Specification<Product> withFilters(String name, String description, Double minPrice, Double maxPrice, Long productTypeId) {
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                if (name != null && !name.isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
                }

                if (description != null && !description.isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("description"), "%" + description + "%"));
                }

                if (minPrice != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
                }

                if (maxPrice != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
                }

                if (productTypeId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("productType").get("id"), productTypeId));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }

}



package com.igorpdev.czkfoodapi.infrastructure.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.domain.Specification;

public class RestauranteFreteGratisSpec implements Specification<Restaurante> {

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        
        return builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
    }
    
}

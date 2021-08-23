package com.igorpdev.czkfoodapi.infrastructure.repository.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteNomeSemelhanteSpec implements Specification<Restaurante> {

    private String nome;

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        return builder.like(root.get("nome"), "%" + nome + "%");
    }
    
}

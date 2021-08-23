package com.igorpdev.czkfoodapi.infrastructure.repository.spec;

import java.math.BigDecimal;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.domain.Specification;

public class RestauranteSpecs {
    
    public static Specification<Restaurante> freteGratis() {
        return (root, query, builder) -> 
            builder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
    }

    public static Specification<Restaurante> nomeSemelhante(String nome) {
        return (root, query, builder) ->
            builder.like(root.get("nome"), "%" + nome + "%");
    }

}

package com.igorpdev.czkfoodapi.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepositoryQueries;

import org.springframework.stereotype.Repository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
    
@PersistenceContext
private EntityManager manager;

@Override
public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
    
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    
    CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
    criteria.from(Restaurante.class);
    
    TypedQuery<Restaurante> query = manager.createQuery(criteria);
    return query.getResultList();

    }

}

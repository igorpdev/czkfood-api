package com.igorpdev.czkfoodapi.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepositoryQueries;

import org.springframework.stereotype.Repository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
    
@PersistenceContext
private EntityManager manager;

@Override
public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
    var jpql = "FROM Restaurante WHERE nome LIKE :nome AND taxaFrete BETWEEN :taxaInicial AND :taxaFinal";

    return manager.createQuery(jpql, Restaurante.class)
        .setParameter("nome", "%" + "nome" + "%")
        .setParameter("taxaInicial", taxaFreteInicial)
        .setParameter("taxaFinal", taxaFreteFinal)
        .getResultList();
}

}

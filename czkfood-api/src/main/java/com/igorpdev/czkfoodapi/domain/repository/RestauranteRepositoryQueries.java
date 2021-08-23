package com.igorpdev.czkfoodapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}

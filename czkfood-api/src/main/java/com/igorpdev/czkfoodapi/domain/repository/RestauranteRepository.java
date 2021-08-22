package com.igorpdev.czkfoodapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
        
    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);

}

package com.igorpdev.czkfoodapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
        
    List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    //@Query("FROM Restaurante WHERE nome LIKE %:nome% AND cozinha.id = :id")
    List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinhaId);
    
    //List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);

    Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    int countByCozinhaId(Long cozinhaId);

}

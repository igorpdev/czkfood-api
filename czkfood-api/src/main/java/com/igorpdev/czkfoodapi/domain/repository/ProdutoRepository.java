package com.igorpdev.czkfoodapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Produto;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQueries {

    @Query("from Produto where restaurante.id = :restaurante and id = :produto")
    Optional<Produto> findById(@Param("restaurante") Long restauranteId, 
            @Param("produto") Long produtoId);
    
    List<Produto> findAllByRestaurante(Restaurante restaurante);

    @Query("FROM Produto p WHERE p.ativo = true AND p.restaurante = :restaurante")
    List<Produto> findAtivosByRestaurante(Restaurante restaurante);
    
}

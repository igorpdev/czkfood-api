package com.igorpdev.czkfoodapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Pedido;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {

    Optional<Pedido> findByCodigo(String codigo);

    @Query("FROM Pedido p JOIN FETCH p.cliente JOIN FETCH p.restaurante r JOIN FETCH r.cozinha")
    List<Pedido> findAll();

}

package com.igorpdev.czkfoodapi.domain.repository;

import com.igorpdev.czkfoodapi.domain.model.Pedido;

import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CustomJpaRepository<Pedido, Long> {

}

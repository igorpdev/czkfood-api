package com.igorpdev.czkfoodapi.domain.repository;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
        
}

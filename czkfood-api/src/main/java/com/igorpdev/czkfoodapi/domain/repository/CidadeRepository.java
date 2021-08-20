package com.igorpdev.czkfoodapi.domain.repository;

import com.igorpdev.czkfoodapi.domain.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
 
}

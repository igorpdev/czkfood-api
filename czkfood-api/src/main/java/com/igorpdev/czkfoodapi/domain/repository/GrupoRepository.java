package com.igorpdev.czkfoodapi.domain.repository;

import com.igorpdev.czkfoodapi.domain.model.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    
}

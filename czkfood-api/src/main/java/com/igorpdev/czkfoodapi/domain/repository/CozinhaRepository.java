package com.igorpdev.czkfoodapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    
    List<Cozinha> findTodasByNomeContaining(String nome);
	
	Optional<Cozinha> findByNome(String nome);
    
}

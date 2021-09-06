package com.igorpdev.czkfoodapi.infrastructure.repository;

import com.igorpdev.czkfoodapi.domain.model.Usuario;
import com.igorpdev.czkfoodapi.domain.repository.CustomJpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

}

package com.igorpdev.czkfoodapi.domain.repository;

import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}

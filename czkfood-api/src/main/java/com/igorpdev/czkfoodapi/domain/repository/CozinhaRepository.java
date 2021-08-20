package com.igorpdev.czkfoodapi.domain.repository;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;

public interface CozinhaRepository {
    
    List<Cozinha> listar();
    List<Cozinha> consultarPorNome(String nome);
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);
    
}

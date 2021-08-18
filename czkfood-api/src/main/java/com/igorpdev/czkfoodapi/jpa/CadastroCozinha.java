package com.igorpdev.czkfoodapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.springframework.stereotype.Component;

@Component
public class CadastroCozinha {
    
    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> listar() {
        return manager.createQuery("from Cozinha", Cozinha.class)
            .getResultList();
    }
}

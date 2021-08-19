package com.igorpdev.czkfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.repository.CozinhaRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listar() {
        return manager.createQuery("from Cozinha", Cozinha.class)
            .getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional //para ser executado dentro de uma transação
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    /* É necessário fazer um find antes de remover para que a cozinha passe do estado Transient para Managed.
            Não há problema colocar o if para verificar se a Cozinha existe no Repository invés do
                Service, pois ela está diretamente ligada à Persistência no banco de dados */

    @Override
    @Transactional
    public void remover(Long id) {
        Cozinha cozinha = buscar(id); 

        if(cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }

        manager.remove(cozinha);          
    }

}

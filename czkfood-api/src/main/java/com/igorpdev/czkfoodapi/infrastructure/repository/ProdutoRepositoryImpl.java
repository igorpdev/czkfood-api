package com.igorpdev.czkfoodapi.infrastructure.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.igorpdev.czkfoodapi.domain.model.FotoProduto;
import com.igorpdev.czkfoodapi.domain.repository.ProdutoRepositoryQueries;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryQueries {
    
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @Override
    public FotoProduto save(FotoProduto foto) {
        return manager.merge(foto);
    }

    @Override
    public void delete(FotoProduto fotoProduto) {
        manager.remove(fotoProduto);
    }

}
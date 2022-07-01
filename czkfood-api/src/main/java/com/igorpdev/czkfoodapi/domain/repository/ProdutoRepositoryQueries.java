package com.igorpdev.czkfoodapi.domain.repository;

import com.igorpdev.czkfoodapi.domain.model.FotoProduto;

public interface ProdutoRepositoryQueries {

    FotoProduto save(FotoProduto fotoProduto);

    void delete(FotoProduto fotoProduto);
    
}
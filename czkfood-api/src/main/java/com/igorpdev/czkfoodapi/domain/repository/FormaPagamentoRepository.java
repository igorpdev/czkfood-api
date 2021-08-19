package com.igorpdev.czkfoodapi.domain.repository;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
    
    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento formaPagamento);
    void remover(FormaPagamento formaPagamento);
    
}

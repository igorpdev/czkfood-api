package com.igorpdev.czkfoodapi.domain.service;

import com.igorpdev.czkfoodapi.domain.exception.PermissaoNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.model.Permissao;
import com.igorpdev.czkfoodapi.domain.repository.PermissaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;
    
    public Permissao buscarOuFalhar(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
            .orElseThrow(() -> new PermissaoNaoEncontradaException(permissaoId));
    }
    
}

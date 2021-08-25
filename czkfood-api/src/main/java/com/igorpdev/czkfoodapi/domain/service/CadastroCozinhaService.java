package com.igorpdev.czkfoodapi.domain.service;

import com.igorpdev.czkfoodapi.domain.exception.CozinhaNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.exception.EntidadeEmUsoException;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.repository.CozinhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/* É um tipo de classe vinda da arquitetura DDD (Domain Driven Design) */

@Service
public class CadastroCozinhaService {

    private static final String MSG_COZINHA_EM_USO = 
        "Cozinha de código %d não pode ser removida, pois está em uso";

    @Autowired
    private CozinhaRepository cozinhaRepository;
    
    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
        } 
        catch (EmptyResultDataAccessException e) {
            throw new CozinhaNaoEncontradaException((cozinhaId));
        }
        catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                String.format(MSG_COZINHA_EM_USO, cozinhaId));
        }
    }

    public Cozinha buscarOuFalhar(Long cozinhaId) {
        return cozinhaRepository.findById(cozinhaId)
            .orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));
    }

}

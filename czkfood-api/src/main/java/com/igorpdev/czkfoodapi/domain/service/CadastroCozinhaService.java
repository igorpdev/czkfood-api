package com.igorpdev.czkfoodapi.domain.service;

import com.igorpdev.czkfoodapi.domain.exception.EntidadeEmUsoException;
import com.igorpdev.czkfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.repository.CozinhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/* É um tipo de classe vinda da arquitetura DDD (Domain Driven Design) */

@Service
public class CadastroCozinhaService {

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
            throw new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId));

                /* É interessante para projetos menores onde você não quer criar uma Exception.
                    Entretanto, não é uma boa prática deixar o Status HTTP na classe de serviço 
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Não existe um cadastro de cozinha com o código %d", cozinhaId)); */
        }
        catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }

}

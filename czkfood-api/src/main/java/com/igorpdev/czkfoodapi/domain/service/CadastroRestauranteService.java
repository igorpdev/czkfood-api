package com.igorpdev.czkfoodapi.domain.service;

import com.igorpdev.czkfoodapi.domain.exception.RestauranteNaoEncontradoException;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroRestauranteService {
    
    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CadastroCozinhaService cadastroCozinha;

    @Transactional
    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
            .orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
    }

}

package com.igorpdev.czkfoodapi.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.CozinhaRepository;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {
    
    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}

    @GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

    @GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorNomeECozinha(String nome, Long cozinhaId) {
		return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
	}
    
}

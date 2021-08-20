package com.igorpdev.czkfoodapi.api.controller;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @GetMapping("/{idRestaurante}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long idRestaurante) {
        Restaurante restaurante = restauranteRepository.buscar(idRestaurante);

        if(restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }

        return ResponseEntity.notFound().build();
    }
}

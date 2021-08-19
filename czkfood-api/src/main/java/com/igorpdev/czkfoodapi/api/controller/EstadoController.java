package com.igorpdev.czkfoodapi.api.controller;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.model.Estado;
import com.igorpdev.czkfoodapi.domain.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
    
    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.listar();
    }
}
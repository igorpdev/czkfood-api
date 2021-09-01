package com.igorpdev.czkfoodapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.igorpdev.czkfoodapi.api.assembler.RestauranteInputDisassembler;
import com.igorpdev.czkfoodapi.api.assembler.RestauranteModelAssembler;
import com.igorpdev.czkfoodapi.api.model.RestauranteModel;
import com.igorpdev.czkfoodapi.api.model.input.RestauranteInput;
import com.igorpdev.czkfoodapi.domain.exception.CozinhaNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.exception.NegocioException;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepository;
import com.igorpdev.czkfoodapi.domain.service.CadastroRestauranteService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private RestauranteModelAssembler assembler;

    @Autowired
    private RestauranteInputDisassembler disassembler;

    @GetMapping
    public List<RestauranteModel> listar() {
        return assembler.toCollectionModel(restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteModel buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return assembler.toModel(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
        try {
            Restaurante restaurante = disassembler.toDomainObject(restauranteInput);
            
            return assembler.toModel(cadastroRestaurante.salvar(restaurante));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{restauranteId}")
    public RestauranteModel atualizar(@PathVariable Long restauranteId, @RequestBody @Valid RestauranteInput restauranteInput) {		
        try {
            Restaurante restaurante = disassembler.toDomainObject(restauranteInput);

            Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

            BeanUtils.copyProperties(restaurante, restauranteAtual, 
                "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

            return assembler.toModel(cadastroRestaurante.salvar(restauranteAtual));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        }        
    }

}

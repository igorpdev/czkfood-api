package com.igorpdev.czkfoodapi.api.controller;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.exception.EstadoNaoEncontradoException;
import com.igorpdev.czkfoodapi.domain.exception.NegocioException;
import com.igorpdev.czkfoodapi.domain.model.Cidade;
import com.igorpdev.czkfoodapi.domain.repository.CidadeRepository;
import com.igorpdev.czkfoodapi.domain.service.CadastroCidadeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public Cidade buscar(@PathVariable Long cidadeId) {
        return cadastroCidade.buscarOuFalhar(cidadeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody Cidade cidade) {
        try {
            return cadastroCidade.salvar(cidade); 
        } catch (EstadoNaoEncontradoException e) { // Necessário para disparar o Status BAD REQUEST ao consumidor
            throw new NegocioException(e.getMessage(), e); // tentar criar uma cidade com um estado inexistente
        }
    }

    @PutMapping("/{cidadeId}")
    public Cidade atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
        try {
            Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
                
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");

            return cadastroCidade.salvar(cidadeAtual);
        } catch (EstadoNaoEncontradoException e) { // Necessário para disparar o Status BAD REQUEST ao consumidor
            throw new NegocioException(e.getMessage(), e); // tentar atualizar uma cidade com um estado inexistente
        }
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
        cadastroCidade.excluir(cidadeId);
    }

}

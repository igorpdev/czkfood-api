package com.igorpdev.czkfoodapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.igorpdev.czkfoodapi.api.assembler.PedidoInputDisassembler;
import com.igorpdev.czkfoodapi.api.assembler.PedidoModelAssembler;
import com.igorpdev.czkfoodapi.api.assembler.PedidoResumoModelAssembler;
import com.igorpdev.czkfoodapi.api.model.PedidoModel;
import com.igorpdev.czkfoodapi.api.model.PedidoResumoModel;
import com.igorpdev.czkfoodapi.api.model.input.PedidoInput;
import com.igorpdev.czkfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.exception.NegocioException;
import com.igorpdev.czkfoodapi.domain.model.Pedido;
import com.igorpdev.czkfoodapi.domain.model.Usuario;
import com.igorpdev.czkfoodapi.domain.repository.PedidoRepository;
import com.igorpdev.czkfoodapi.domain.service.EmissaoPedidoService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private EmissaoPedidoService emissaoPedido;
    
    @Autowired
    private PedidoModelAssembler pedidoModelAssembler;

    @Autowired
    private PedidoResumoModelAssembler pedidoResumoModelAssembler;

    @Autowired
    private PedidoInputDisassembler pedidoInputDisassembler;
    
        /* Por padrão, retornarão todos os campos. Se o consumidor inserir algum campo no
                parâmetro da requisição, retornará apenas o(s) desejado(s) */
    @GetMapping
    public MappingJacksonValue listar(@RequestParam(required = false) String campos) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoResumoModel> pedidosModel = pedidoResumoModelAssembler.toCollectionModel(pedidos);
        
        MappingJacksonValue pedidosWrapper = new MappingJacksonValue(pedidosModel);

        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("pedidoFilter", SimpleBeanPropertyFilter.serializeAll());

        if (StringUtils.isNotBlank(campos)) {
            filterProvider.addFilter("pedidoFilter", SimpleBeanPropertyFilter.filterOutAllExcept(campos.split(",")));
        }

        pedidosWrapper.setFilters(filterProvider);

        return pedidosWrapper;
    }

    /* @GetMapping
    public List<PedidoResumoModel> listar() {
        List<Pedido> todosPedidos = pedidoRepository.findAll();
        
        return pedidoResumoModelAssembler.toCollectionModel(todosPedidos);
    } */
    
    @GetMapping("/{codigoPedido}")
    public PedidoModel buscar(@PathVariable String codigoPedido) {
        Pedido pedido = emissaoPedido.buscarOuFalhar(codigoPedido);
        
        return pedidoModelAssembler.toModel(pedido);
    } 

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoModel adicionar(@RequestBody @Valid PedidoInput pedidoInput) {
        try {
            Pedido novoPedido = pedidoInputDisassembler.toDomainObject(pedidoInput);

            //TODO: usuário autenticado
            novoPedido.setCliente(new Usuario());
            novoPedido.getCliente().setId(1L);

            novoPedido = emissaoPedido.emitir(novoPedido);

            return pedidoModelAssembler.toModel(novoPedido);
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

}

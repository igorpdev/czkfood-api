package com.igorpdev.czkfoodapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.igorpdev.czkfoodapi.api.model.PedidoResumoModel;
import com.igorpdev.czkfoodapi.domain.model.Pedido;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoResumoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public PedidoResumoModel toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoResumoModel.class);
    }
    
    public List<PedidoResumoModel> toCollectionModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(pedido -> toModel(pedido))
                .collect(Collectors.toList());
    }
    
}

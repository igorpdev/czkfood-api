package com.igorpdev.czkfoodapi.api.assembler;

import com.igorpdev.czkfoodapi.api.model.FotoProdutoModel;
import com.igorpdev.czkfoodapi.domain.model.FotoProduto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FotoProdutoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public FotoProdutoModel toModel(FotoProduto foto) {
        return modelMapper.map(foto, FotoProdutoModel.class);
    }
    
}

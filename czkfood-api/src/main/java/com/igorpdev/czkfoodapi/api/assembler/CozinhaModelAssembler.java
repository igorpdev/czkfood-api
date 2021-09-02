package com.igorpdev.czkfoodapi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.igorpdev.czkfoodapi.api.model.CozinhaModel;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CozinhaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public CozinhaModel toModel(Cozinha cozinha) {
        return modelMapper.map(cozinha, CozinhaModel.class);
    }
    
    public List<CozinhaModel> toCollectionModel(List<Cozinha> cozinhas) {
        return cozinhas.stream()
                .map(cozinha -> toModel(cozinha))
                .collect(Collectors.toList());
    }   
}   

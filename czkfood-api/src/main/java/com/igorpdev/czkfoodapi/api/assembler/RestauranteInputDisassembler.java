package com.igorpdev.czkfoodapi.api.assembler;

import com.igorpdev.czkfoodapi.api.model.input.RestauranteInput;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }

}

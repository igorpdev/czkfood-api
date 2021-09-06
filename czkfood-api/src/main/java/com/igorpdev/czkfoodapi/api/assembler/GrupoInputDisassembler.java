package com.igorpdev.czkfoodapi.api.assembler;

import com.igorpdev.czkfoodapi.api.model.input.GrupoInput;
import com.igorpdev.czkfoodapi.domain.model.Grupo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GrupoInputDisassembler {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public Grupo toDomainObject(GrupoInput grupoInput) {
        return modelMapper.map(grupoInput, Grupo.class);
    }
    
    public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
        modelMapper.map(grupoInput, grupo);
    }   

}

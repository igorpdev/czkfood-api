package com.igorpdev.czkfoodapi.api.model.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.stereotype.Component;

@Component
public abstract class CozinhaMixin {
    
    @JsonIgnore
    private List<Restaurante> restaurantes;

}

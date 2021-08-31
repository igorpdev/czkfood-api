package com.igorpdev.czkfoodapi.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.igorpdev.czkfoodapi.domain.model.Estado;

public abstract class CidadeMixin {
    
    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Estado estado;

}

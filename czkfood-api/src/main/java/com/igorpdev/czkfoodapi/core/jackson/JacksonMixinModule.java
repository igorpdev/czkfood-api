package com.igorpdev.czkfoodapi.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.igorpdev.czkfoodapi.api.model.mixin.CozinhaMixin;
import com.igorpdev.czkfoodapi.api.model.mixin.CidadeMixin;
import com.igorpdev.czkfoodapi.domain.model.Cidade;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {
    

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}

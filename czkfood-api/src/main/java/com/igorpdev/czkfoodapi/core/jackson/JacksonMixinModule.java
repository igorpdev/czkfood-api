package com.igorpdev.czkfoodapi.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.igorpdev.czkfoodapi.api.model.mixin.RestauranteMixin;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {
    

    public JacksonMixinModule() {
        setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
    }

}

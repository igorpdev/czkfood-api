package com.igorpdev.czkfoodapi.api.assembler;

import com.igorpdev.czkfoodapi.api.model.input.RestauranteInput;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;

import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDisassembler {
    
    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteInput.getNome());
        restaurante.setTaxaFrete(restauranteInput.getTaxaFrete());

        Cozinha cozinha = new Cozinha();
        cozinha.setId(restauranteInput.getCozinha().getId());

        restaurante.setCozinha(cozinha);

        return restaurante;
    }

}

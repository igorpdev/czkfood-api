package com.igorpdev.czkfoodapi.jpa;

import java.util.List;

import com.igorpdev.czkfoodapi.CzkfoodApiApplication;
import com.igorpdev.czkfoodapi.domain.model.Restaurante;
import com.igorpdev.czkfoodapi.domain.repository.RestauranteRepository;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ConsultaRestauranteMain {
    
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(CzkfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        List<Restaurante> restaurantes = restauranteRepository.listar();

        for(Restaurante restaurante : restaurantes) {
            System.out.printf("%s - %f - %s\n", restaurante.getNome(), restaurante.getTaxaFrete(),
                    restaurante.getCozinha().getNome());
        }
    }
}

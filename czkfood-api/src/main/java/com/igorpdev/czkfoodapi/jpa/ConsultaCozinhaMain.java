package com.igorpdev.czkfoodapi.jpa;

import java.util.List;

import com.igorpdev.czkfoodapi.CzkfoodApiApplication;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ConsultaCozinhaMain {
    
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(CzkfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        List<Cozinha> cozinhas = cadastroCozinha.listar();

        for(Cozinha cozinha : cozinhas) {
            System.out.println(cozinha.getNome());
        }
    }
}

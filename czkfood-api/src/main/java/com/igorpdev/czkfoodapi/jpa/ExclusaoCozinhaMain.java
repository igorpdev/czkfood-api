package com.igorpdev.czkfoodapi.jpa;

import com.igorpdev.czkfoodapi.CzkfoodApiApplication;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoCozinhaMain {
    
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(CzkfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);

        cadastroCozinha.remover(cozinha);
    }
}

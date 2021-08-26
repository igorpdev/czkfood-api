package com.igorpdev.czkfoodapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
    
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parametro inválido");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://czkfood.com" + path;
        this.title = title;
    }

}

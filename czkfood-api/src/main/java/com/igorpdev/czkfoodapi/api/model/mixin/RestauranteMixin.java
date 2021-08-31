package com.igorpdev.czkfoodapi.api.model.mixin;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.model.Endereco;
import com.igorpdev.czkfoodapi.domain.model.FormaPagamento;
import com.igorpdev.czkfoodapi.domain.model.Produto;

public abstract class RestauranteMixin {
    
    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

    @JsonIgnore
    private List<Produto> produtos;

    @JsonIgnore
    private LocalDateTime dataCadastro;

    @JsonIgnore
    private LocalDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento;

}

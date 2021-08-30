package com.igorpdev.czkfoodapi;

import com.igorpdev.czkfoodapi.domain.model.Cozinha;
import com.igorpdev.czkfoodapi.domain.service.CadastroCozinhaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintViolationException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroCozinhaIntegrationTests {

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

	@Test
    public void testarCadastroCozinhaComSucesso() {
        // Cenário
        Cozinha novaCozinha = new Cozinha();
        novaCozinha.setNome("Chinesa");

        // Ação
        novaCozinha = cadastroCozinha.salvar(novaCozinha);

        // Validação
        assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
    }

    @Test
	public void testarCadastroCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					cadastroCozinha.salvar(novaCozinha);
				});

		assertThat(erroEsperado).isNotNull();
	}

}

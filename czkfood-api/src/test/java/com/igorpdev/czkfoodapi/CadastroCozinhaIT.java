package com.igorpdev.czkfoodapi;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CadastroCozinhaIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.port = port;
        RestAssured.basePath = "/cozinhas";
    }
    
    @Test
    public void deveRetornarStatus200_QuandoConsultarCozinhas() {        
        RestAssured.given()
            .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .statusCode(200);
    }

    @Test
    public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
        RestAssured.given()
            .accept(ContentType.JSON)
        .when()
            .get()
        .then()
            .body("", Matchers.hasSize(4))
            .body("nome", Matchers.hasItems("Indiana", "Tailandesa"));
    }

}

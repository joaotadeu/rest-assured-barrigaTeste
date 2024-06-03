package br.com.joaotadeu.rest.tests;

import br.com.joaotadeu.core.baseTeste;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class barrigaTest extends baseTeste {

    private String TOKEN;

    @Before
    public void login(){
        Map<String, String> login = new HashMap<>();
        login.put("email", "joaotadeu@gmail.com");
        login.put("senha", "123qwe");

        // Fazer a requisição POST para obter o token
        TOKEN = given()
                .body(login)
                .post("/signin")
                .path("token");

        System.out.println("Token: " + TOKEN);

    }

    @Test
    public void naoDeveAcessarSemToken(){
        get("/contas").then().statusCode(401);
    }

    @Test
    public void deveIncluirContaComSucesso(){

        // Fazer a requisição POST com o token e o corpo
        given()
                .header("Authorization", "JWT " + token)
                .body("{ \"nome\": \"conta qualquer\" }")
                .post("/contas")
                .then()
                .statusCode(201);  // Supondo que a criação da conta retorna 201 (Criado)
    }
}

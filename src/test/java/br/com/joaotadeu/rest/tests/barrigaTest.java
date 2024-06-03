package br.com.joaotadeu.rest.tests;

import br.com.joaotadeu.core.baseTeste;
import org.junit.Test;

import static io.restassured.RestAssured.get;

public class barrigaTest extends baseTeste {

    @Test
    public void naoDeveAcessarSemToken(){
        get("/contas").then().statusCode(401);
    }
}

package br.com.joaotadeu.core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class baseTeste implements Constantes {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = APP_BASE_URL;
        //RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENTE_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}

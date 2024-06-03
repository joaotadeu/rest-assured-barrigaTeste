package br.com.joaotadeu.core;

import io.restassured.http.ContentType;

public interface Constantes {
    String APP_BASE_URL = "http://barrigarest.wcaquino.me";
    String APP_PORT = "80";
    String APP_BASE_PATH = "";

    ContentType APP_CONTENTE_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
}

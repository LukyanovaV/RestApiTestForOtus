package com.dictionary.test;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class RestAssuredTest {
    private static final String API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String API_KEY = "trnsl.1.1.20180711T123306Z.b012f6b5034cc719.aff4999263480fef925a97d8863cbccc7ab40f50";
    @Test
    public void dictionaryTest(){
        RestAssured.useRelaxedHTTPSValidation();//SSL
        given()
                //.header("User-Agent", "Mozilla...")
                //.header("JWT", "jwt_token")
                .when()
                .get(API_URL+getPathFormated(API_KEY,"Привет мир", "ru-en"))
                .then()
                .statusCode(200)
                .body("text[0]", equalTo("Hello world"))
                .body("code",equalTo(200))
                .body("link",equalTo("null"));

    }



        protected String getPathFormated(String key, String text, String languageFormat) {
            return String.format("?key=%s&text=%s&lang=%s", key, text, languageFormat);
        }

    @Test
    public void unirestTest() throws UnirestException {
            String response = Unirest.get(API_URL+getPathFormated(API_KEY,"Привет%20мир", "ru-en")).asString().getBody();
            System.out.println(response);
        }

}

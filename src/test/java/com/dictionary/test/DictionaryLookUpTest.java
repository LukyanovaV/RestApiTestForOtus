package com.dictionary.test;

import com.dictionary.api.DictionaryApiUrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(value = Parameterized.class)
public class DictionaryLookUpTest {

    private static final String API_KEY = "dict.1.1.20180802T124642Z.66d9a8756ab67342.6313d4ca697dd0d737e0f28c74847c5f84851259";


    private String ruWord;
    private String engWord;

    public DictionaryLookUpTest(String ruWord, String engWord){
        this.ruWord = ruWord;
        this.engWord = engWord;
    }

    @Parameterized.Parameters
    public static List<Object[]> dataGetLangs(){
        Object[][] data = new Object[][] {{"время","time"},{"собака", "dog"}};
        return  Arrays.asList(data);
    }


    @Test
    public void getLookUpWordTest(){

        given()
                .when()
                .get(DictionaryApiUrl.getLookUpUrl(API_KEY,"ru-en",ruWord))
                .then()
                .statusCode(200)
                .body("def[0].text", equalTo(ruWord))
                .body("def[0].tr[0].text", equalTo(engWord));

    }

}

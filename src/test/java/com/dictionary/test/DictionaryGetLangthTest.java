package com.dictionary.test;

import com.dictionary.api.DictionaryApiUrl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.collection.IsMapContaining.hasValue;

@RunWith(value = Parameterized.class)
public class DictionaryGetLangthTest {

    private static final String API_KEY = "dict.1.1.20180802T124642Z.66d9a8756ab67342.6313d4ca697dd0d737e0f28c74847c5f84851259";

    private String dataLang;


    public DictionaryGetLangthTest(String dataLang){
        this.dataLang=dataLang;
    }

    @Parameterized.Parameters
    public static List<Object[]> dataGetLangs(){
        Object[][] data = new Object[][] {{"ru-es"},{"ru-en"},{"ru-ru"},{"ru-uk"},{"ru-de"},{"ru-fr"},{"ru-it"},{"ru-tr"},{"en-ru"},{"en-en"},{"en-de"},{"en-fr"},{"en-es"},{"en-it"},{"en-tr"},{"pl-ru"},{"uk-ru"},{"de-ru"},{"de-en"},{"fr-ru"},{"fr-en"},{"es-ru"},{"es-en"},{"it-ru"},{"it-en"},{"tr-ru"},{"tr-en"}};
        return  Arrays.asList(data);
    }


    @Test
    public void getLangsTest(){

        given()
                .when()
                .get(DictionaryApiUrl.getLangsUrl(API_KEY))
                .then()
                .statusCode(200)
                .body("$", hasItem(dataLang));

    }

}

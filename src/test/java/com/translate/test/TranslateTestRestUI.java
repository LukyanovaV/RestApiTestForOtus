package com.translate.test;

import com.codeborne.selenide.Condition;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.translate.api.TranslateYandexApi;
import com.jayway.jsonpath.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@RunWith(value = Parameterized.class)
public class TranslateTestRestUI {

    public static String API_KEY = "trnsl.1.1.20180806T115236Z.c258c5897187811d.e0a8e4af73eb301ffe26fdeb30c1470dc17b7348";


    String lang;
    String textQuery;
    String textResult;

    public TranslateTestRestUI(String lang, String textQuery){
        this.lang = lang;
        this.textQuery = textQuery;
    }


    @Parameterized.Parameters
    public static List<Object[]> dataGetLangs(){
        Object[][] data = new Object[][] {{"en-ru","Hello"},{"en-ru", "Hello Word"},{"ru-en", "Город"}};
        return  Arrays.asList(data);
    }


    @Before
    public void setUp() throws UnirestException {

        String json = Unirest.get("https://translate.yandex.net/api/v1.5/tr.json/translate")
                .queryString("key", API_KEY)
                .queryString("text",textQuery)
                .queryString("lang", lang)
                .queryString("format","plain")
                .asString()
                .getBody();

        textResult = JsonPath.read(json, "$.text[0]").toString();
    }

    @Test
    public void translateRestUITest(){
        open(TranslateYandexApi.getURLHome(lang,textQuery));
        $("span.translation-chunk").should(Condition.text(textResult));

    }


}

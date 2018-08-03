package com.dictionary.test;

import com.dictionary.api.DictionaryClient;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DictionaryApiTest {

    @Test
    public void firstTest(){
        DictionaryClient dictionaryClient = new DictionaryClient();
        String translation = dictionaryClient.sendGet("Привет", "ru-en");
        assertThat(translation, equalTo("Hi"));
    }
}

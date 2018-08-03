package com.dictionary.api;

public class DictionaryApiUrl {

    private static final String API_URL = "https://dictionary.yandex.net/api/v1/dicservice.json";

    public static String getLangsUrl(String Api_Key){
        return String.format("%s/getLangs?key=%s", API_URL, Api_Key);
    }

    public static String getLookUpUrl(String Api_Key, String lang, String text){
        return String.format("%s/lookup?key=%s&lang=%s&text=%s", API_URL, Api_Key, lang, text);
    }

}

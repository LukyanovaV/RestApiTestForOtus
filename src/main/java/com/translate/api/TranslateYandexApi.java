package com.translate.api;

public class TranslateYandexApi {

    private static final String API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String HOME_URL = "https://translate.yandex.ru/";


    public static String getURLApi(String Api_Key, String text, String lang){
        return String.format("%s?key=%s&text=%s&lang=%s", API_URL, Api_Key, text, lang);
    }

    public static String getURLHome(String lang, String text){
        return String.format("%s?lang=%s&text=%s", HOME_URL, lang, text);
    }

}

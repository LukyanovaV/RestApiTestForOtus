package com.dictionary.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {

        URL myUrl = new URL("http://pro-java.ru");
        HttpURLConnection myUrlCon =
                (HttpURLConnection) myUrl.openConnection();

        // Вывести метод запроса

        System.out.println("Метод запроса: " +
                myUrlCon.getRequestMethod());

        // Вывести код ответа

        System.out.println("Ответное сообщение: " +
                myUrlCon.getResponseMessage());

        // Получить список полей и множество ключей из заголовка

        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
        Set<String> myField = myMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // Вывести все ключи и значения из заголовка
        for(String k : myField) {
            System.out.println("Ключ: " + k + " Значение: "
                    + myMap.get(k));
        }
    }
}

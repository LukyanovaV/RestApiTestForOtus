package com.dictionary.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DictionaryClient {

    private static final String API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String API_KEY = "trnsl.1.1.20180711T123306Z.b012f6b5034cc719.aff4999263480fef925a97d8863cbccc7ab40f50";

           public String sendGet(String textForTranslation, String languageFormat) {
                DictionarySchema dictionaryClient = new DictionarySchema();
                String urlPath = dictionaryClient.getPathFormated(API_KEY, textForTranslation, languageFormat);
                String urlFinal = API_URL + urlPath;

                        String result = null;
                try {
                        URL url = new URL(urlFinal);

                        //HttpURLConnection, производный от класса URLConnection и поддерживающий соединения по сетевому протоколу НТТР.
                        // Чтобы получить объект класса HttpURLConnection, следует вызвать метод openConnection()
                                HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                        //void setRequestмethod(String способ) throws ProtocolZxception - задает метод, которым делаются запросы по прото­колу HTTP,
                        // в соответствии со значением параметра способ. По умолчанию принят метод GET, но доступны и другие методы, в том числе POST.
                        // Если в качестве параметра способ указано неправильное значение, то генерируется исключение типа ProtocolExoeption.
                                connection.setRequestMethod("GET");


                        //int getResponseCode() throws IOException - возвращает код ответа по протоколу НТТР.
                        // Если код ответа не может быть получен, возвращается значе­ние - 1.
                        // При разрыве соединения генерируется исклю­чение типа IОЕхсерtiоn.
                                int responseCode = connection.getResponseCode();

                        //getInputStream() - возвращает ответ из потока, включая заголовки ответов и метаданные, такие как тип и длина содержимого тела
                        // ответа, измененные даты и куки сеанса. Если ответ не имеет тела, этот метод возвращает пустой поток.
                                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                                StringBuffer response = new StringBuffer();
                        String inputLine = null;

                                while((inputLine = br.readLine()) != null) {
                                response.append(inputLine);
                            }
                        br.close();

                                result = response.toString();

                               return result;

                            } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                       e.printStackTrace();
                    }

                        return result;
            }

            private class DictionarySchema {
        private final static String KEY = "key";
        private final static String TEXT = "text";
        private final static String LANG = "lang";

                protected String getPathFormated(String key, String text, String languageFormat) {
                        return String.format("?key=%s&text=%s&lang=%s", key, text, languageFormat);
                    }
    }
}


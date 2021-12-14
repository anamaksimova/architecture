package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;

import java.util.Deque;

public class ResponseBuilder {
    StringBuilder response = new StringBuilder();
    String codeDescription;
    String reply;
    public HttpResponse chooseResponse(String code){
       String httpVersion = Config.HTTPVersion;
        switch (code) {
            case  ("404"):
                codeDescription   = "404 NOT_FOUND";
                break;
            case ("200"):
                codeDescription   = "200 OK";
                break;
            case ("405"):
                codeDescription   =  "405 METHOD_NOT_ALLOWED";
                break;

        }
      String header = Config.HEADER;
        switch (code) {
            case  ("404"):
                reply   = "<h1>Файл не найден!</h1>";
                break;
            case ("200"):
                reply   = "\n";
                break;
            case ("405"):
                reply   = "<h1>Метод не поддерживается!</h1>";
                break;

        }


        return new HttpResponse(httpVersion, codeDescription,header,reply);}


}

package ru.geekbrains;

import ru.geekbrains.config.Configuration;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResponseBuilder {
    protected final Configuration config;


    String codeDescription;
    String reply;


    public ResponseBuilder(Configuration config) {
        this.config = config;
    }

    public HttpResponse chooseResponse(String code,HttpRequest request){
        Path path = Paths.get(config.getWwwHome(), request.getUrl());
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
                StringBuilder sb = new StringBuilder();
                try {
                    Files.readAllLines(path).forEach(sb::append);
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
                reply   = "\n"+ sb;
                break;
            case ("405"):
                reply   = "<h1>Метод не поддерживается!</h1>";
                break;

        }



        HttpResponse httpResponse = HttpResponse.createBuilder()
               .withHttpVersion(httpVersion)
                .withCodeDescription(codeDescription)
                .withHeader(header)
                .withReply(reply)
                .build();
        return httpResponse;}

//        return new HttpResponse(httpVersion, codeDescription,header,reply);}


}

package ru.geekbrains.handler;

import ru.geekbrains.ResponseBuilder;
import ru.geekbrains.config.Configuration;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetMethodHandler extends MethodHandler {

    public GetMethodHandler(String method, MethodHandler next, SocketService socketService, ResponseBuilder responseBuilder, Configuration config) {
        super(method, next, socketService, responseBuilder, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        Path path = Paths.get(config.getWwwHome(), request.getUrl());
        HttpResponse response;
        if (!Files.exists(path)) {
             response = responseBuilder.chooseResponse("404", request);
          //  socketService.writeResponse(response.toString());
            System.out.println(response);
            return response;

        }

        StringBuilder sb = new StringBuilder();
        try {
            Files.readAllLines(path).forEach(sb::append);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
         response = responseBuilder.chooseResponse("200", request);

        return response;
    }
}


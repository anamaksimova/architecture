package ru.geekbrains.handler;

import ru.geekbrains.ResponseBuilder;
import ru.geekbrains.config.Configuration;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

public class PostMethodHandler extends MethodHandler {

    public PostMethodHandler(String method, MethodHandler next, SocketService socketService, ResponseBuilder responseBuilder, Configuration config) {
        super(method, next, socketService, responseBuilder, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        HttpResponse response = responseBuilder.chooseResponse("200", request);
        return response;}

}
package ru.geekbrains.handler;

import ru.geekbrains.ResponseBuilder;
import ru.geekbrains.config.Configuration;
import ru.geekbrains.service.SocketService;

public class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseBuilder responseBuilder, Configuration config) {
        PutMethodHandler putHandler = new PutMethodHandler("PUT", null, socketService, responseBuilder, config);
        PostMethodHandler postHandler = new PostMethodHandler("POST", putHandler, socketService, responseBuilder, config);
        return new GetMethodHandler("GET", postHandler, socketService, responseBuilder, config);
    }
}

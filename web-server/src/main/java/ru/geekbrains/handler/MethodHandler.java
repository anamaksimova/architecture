package ru.geekbrains.handler;


import ru.geekbrains.ResponseBuilder;
import ru.geekbrains.config.Configuration;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

public abstract class MethodHandler {

    private final String method;

    private final MethodHandler next;

    protected final SocketService socketService;

    protected final ResponseBuilder responseBuilder;


    protected final Configuration config;
    public MethodHandler(String method, MethodHandler next, SocketService socketService, ResponseBuilder responseBuilder, Configuration config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseBuilder = responseBuilder;
        this.config = config;
    }

    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = responseBuilder.chooseResponse("405", request);

        }
        socketService.writeResponse(response.toString());

    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}

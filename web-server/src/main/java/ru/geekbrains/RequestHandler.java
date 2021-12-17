package ru.geekbrains;

import ru.geekbrains.config.Configuration;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;



public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private ResponseBuilder responseBuilder;
    private final Configuration config;
    public static RequestHandler createRequestHandler(SocketService socketService, RequestParser requestParser,  ResponseBuilder responseBuilder, Configuration config) {
        return new RequestHandler(socketService,requestParser ,responseBuilder,config);
    }

    private RequestHandler(SocketService socketService, RequestParser requestParser,  ResponseBuilder responseBuilder, Configuration config) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.responseBuilder = responseBuilder;
        this.config = config;
    }



    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
        System.out.println(httpRequest);
        StringBuilder response = new StringBuilder();
        if (httpRequest.getMethod().equals("GET")) {
            Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());

            if (!Files.exists(path)) {
                HttpResponse httpResponse = responseBuilder.chooseResponse("404");
                socketService.writeResponse(httpResponse.toString());
                System.out.println(httpResponse);
                return;
            }
            HttpResponse httpResponse = responseBuilder.chooseResponse("200");
            socketService.writeResponse(httpResponse.toString());

            try {

                Files.readAllLines(path).forEach(response::append);

            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            socketService.writeResponse(response.toString());

            System.out.println(httpResponse);
        //    socketService.writeResponse(response.toString());
        } else {

            HttpResponse httpResponse = responseBuilder.chooseResponse("405");
            socketService.writeResponse(httpResponse.toString());

            return;
        }
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");



    }
}

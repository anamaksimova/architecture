package ru.geekbrains.handler;

import ru.geekbrains.RequestParser;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.service.SocketServiceImpl;
import java.io.*;

import java.util.Deque;



public class RequestHandler implements Runnable {

    private final SocketServiceImpl socketService;
    private final RequestParser requestParser;
    private final MethodHandler methodHandler;
//    private ResponseBuilder responseBuilder;
//    private final Configuration config;
    public static RequestHandler createRequestHandler(SocketServiceImpl socketService, RequestParser requestParser,MethodHandler methodHandler ) {
        return new RequestHandler(socketService,requestParser , methodHandler);
    }

    private RequestHandler(SocketServiceImpl socketService, RequestParser requestParser,  MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
//        this.responseBuilder = responseBuilder;
//        this.config = config;
    }



    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);
        System.out.println(httpRequest);
        StringBuilder response = new StringBuilder();
        methodHandler.handle(httpRequest);
//        if (httpRequest.getMethod().equals("GET")) {
//            Path path = Paths.get(config.getWwwHome(), httpRequest.getUrl());
//
//            if (!Files.exists(path)) {
//                HttpResponse httpResponse = responseBuilder.chooseResponse("404");
//                socketService.writeResponse(httpResponse.toString());
//                System.out.println(httpResponse);
//                return;
//            }
//            HttpResponse httpResponse = responseBuilder.chooseResponse("200");
//            socketService.writeResponse(httpResponse.toString());
//
//            try {
//
//                Files.readAllLines(path).forEach(response::append);
//
//            } catch (IOException e) {
//                throw new IllegalStateException(e);
//            }
//            socketService.writeResponse(response.toString());
//
//            System.out.println(httpResponse);
//        //    socketService.writeResponse(response.toString());
//        } else {
//
//            HttpResponse httpResponse = responseBuilder.chooseResponse("405");
//            socketService.writeResponse(httpResponse.toString());
//
//            return;
//        }
        try {
            socketService.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        System.out.println("Client disconnected!");



    }
}

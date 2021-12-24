package ru.geekbrains;


import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.config.Configuration;
import ru.geekbrains.handler.MethodHandlerFactory;
import ru.geekbrains.handler.RequestHandler;
import ru.geekbrains.service.SocketServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        Configuration config = ConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.printf("Server started at port %d!%n", config.getPort());
            RequestParser requestParser = new RequestParser();


            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                //SocketService socketService = SocketServiceFactory.createSocketService(socket);
                ResponseBuilder responseBuilder = new ResponseBuilder(config);
                new Thread(RequestHandler.createRequestHandler(SocketServiceImpl.createSocketService(socket), requestParser,  MethodHandlerFactory.create(SocketServiceImpl.createSocketService(socket), responseBuilder, config))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

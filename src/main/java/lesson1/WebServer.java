package lesson1;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


import static lesson1.HandleRequest.handleRequest;

public class WebServer {



        public static void main(String[] args) {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("Server started!");

                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("New client connected!");
                    new Thread(() -> handleRequest(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


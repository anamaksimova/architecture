package lesson1;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HandleRequest {
    private static String WWW = "\\Users\\anamaksimova\\Desktop\\spring\\architecture\\www";
    public static void handleRequest(Socket socket) {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            while (!input.ready());

            String firstLine = input.readLine();
            String[] parts = firstLine.split(" ");
            System.out.println(firstLine);
            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path path = Paths.get(WWW, parts[1]);
            if (!Files.exists(path)) {

                Desktop desktop = Desktop.getDesktop();
                File f = new File("C:\\Users\\anamaksimova\\Desktop\\spring\\architecture\\www\\index.html");
                desktop.browse(f.toURI());
//                output.println("HTTP/1.1 404 NOT_FOUND");
//                output.println("Content-Type: text/html; charset=utf-8");
//                output.println();
//                output.println("<h1>Файл не найден!</h1>");
//                output.flush();
                return;
            }

//
//            Desktop desktop = Desktop.getDesktop();
//            File f = new File("C:\\Users\\anamaksimova\\Desktop\\spring\\architecture\\www\\index2.html");
//            desktop.browse(f.toURI());

            output.println("HTTP/1.1 200 OK");
            output.println("Content-Type: text/html; charset=utf-8");
            output.println();

            Files.newBufferedReader(path).transferTo(output);

            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

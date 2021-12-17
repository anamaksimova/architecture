package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {
    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        String method = firstLine[0];
        String url = firstLine[1];

        Map<String, String> headers = new HashMap<>();
        String cookie = null;
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            if (header[0].equals("Cookie")){
                cookie = header[1];
            }
            headers.put(header[0], header[1]);
        }
        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }
//        return new HttpRequest(method, url, headers, body.toString(), cookie);
       HttpRequest httpRequest = HttpRequest.createBuilder()
                .withMethod(method)
                .withUrl(url)
                .withHeaders(headers)
                .withBody(body.toString())
                .withCookie(cookie)
                .build();
        return httpRequest;
    }
}

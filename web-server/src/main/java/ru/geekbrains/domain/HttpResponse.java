package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private  String httpVersion;

    @Override
    public String toString() {
        return  httpVersion + " " +
               codeDescription +
               '\n' + header +
                '\n' + reply ;
    }

    private String codeDescription;

    private final String header;
    private final String reply;
    public HttpResponse(String httpVersion, String codeDescription, String header, String reply) {
        this.httpVersion = httpVersion;
        this.codeDescription = codeDescription;
        this.header = header;
        this.reply = reply;
    }
    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }

    public String getHeader() {
        return header;
    }

    public String getReply() {
        return reply;
    }

}

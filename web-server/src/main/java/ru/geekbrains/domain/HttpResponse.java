package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {


    @Override
    public String toString() {
        return  httpVersion + " " +
               codeDescription +
               '\n' + header +
                '\n' + reply ;
    }
    private  String httpVersion;
    private String codeDescription;

    private  String header;
    private  String reply;
    private HttpResponse(){}
//    public HttpResponse(String httpVersion, String codeDescription, String header, String reply) {
//        this.httpVersion = httpVersion;
//        this.codeDescription = codeDescription;
//        this.header = header;
//        this.reply = reply;
//    }
    public String getHttpVersion() {
        return httpVersion;
    }

//    public void setHttpVersion(String httpVersion) {
//        this.httpVersion = httpVersion;
//    }

    public String getCodeDescription() {
        return codeDescription;
    }

//    public void setCodeDescription(String codeDescription) {
//        this.codeDescription = codeDescription;
//    }

    public String getHeader() {
        return header;
    }

    public String getReply() {
        return reply;
    }
    public static Builder createBuilder() {
        return new Builder();
    }
    public static class Builder{
        private final HttpResponse httpResponse;
        private Builder(){
            this.httpResponse=new HttpResponse();
        }
        public HttpResponse.Builder withHttpVersion(String httpVersion){
            this.httpResponse. httpVersion= httpVersion;
            return this;
        }
        public HttpResponse.Builder withCodeDescription(String codeDescription){
            this.httpResponse.codeDescription=codeDescription;
            return this;
        }
        public HttpResponse.Builder withHeader(String header){
            this.httpResponse.header=header;
            return this;
        }
        public HttpResponse.Builder withReply(String reply){
            this.httpResponse.reply=reply;
            return this;
        }

        public HttpResponse build() {
            return this.httpResponse;
        }

    }

}

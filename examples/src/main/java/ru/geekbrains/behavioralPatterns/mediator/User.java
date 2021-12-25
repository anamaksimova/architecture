package ru.geekbrains.behavioralPatterns.mediator;

public class User {

    String name;
     ChatRoom chatMediator;
     public User(String name, ChatRoom chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }



    public String getName() {
        return this.name;
    }

    public void send(String message) {
        this.chatMediator.showMessage(this, message);
    }
}

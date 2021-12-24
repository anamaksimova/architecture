package ru.geekbrains.behavioralPatterns.mediator;

import java.util.Date;

public class ChatRoom implements ChatRoomMediator{
    public  void showMessage(User user, String message)
    {
        Date date = new Date();
        String sender = user.getName();
        System.out.println(date + "["+ sender + "]"+ message);

    }
}

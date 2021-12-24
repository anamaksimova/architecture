package ru.geekbrains.behavioralPatterns.memento;

public class EditorMemento {
    public EditorMemento(String content) {
        this.content = content;
    }

    String content;

    public String getContent()
    {
        return this.content;
    }
}

package ru.geekbrains.behavioralPatterns.memento;

public class Editor {
   String content = "";
    StringBuilder content1 = new StringBuilder().append(content);

    public void type(String words)
    {
        this.content1 = content1.append(words);
    }

    public String getContent()
    {
        return this.content1.toString();
    }

    public  EditorMemento save()
    {
        return new EditorMemento(this.content1.toString());
    }

    public void restore(EditorMemento memento)
    {
        content = memento.getContent();
        System.out.println(content);
    }
}

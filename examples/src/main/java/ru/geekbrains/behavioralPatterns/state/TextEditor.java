package ru.geekbrains.behavioralPatterns.state;

public class TextEditor {
    public TextEditor(WritingState state) {
        this.state = state;
    }

    WritingState state;



    public void setState(WritingState state)
    {
        this.state = state;
    }

    public void type(String words)
    {
        this.state.write(words);
    }
}

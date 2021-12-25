package ru.geekbrains.behavioralPatterns.visitor;

public interface AnimalOperation {
    public  void visitMonkey(Monkey monkey);
    public void visitLion(Lion lion);

}

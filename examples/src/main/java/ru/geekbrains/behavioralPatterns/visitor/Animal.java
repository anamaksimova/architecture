package ru.geekbrains.behavioralPatterns.visitor;

public interface Animal {
    public void accept(AnimalOperation operation);
}

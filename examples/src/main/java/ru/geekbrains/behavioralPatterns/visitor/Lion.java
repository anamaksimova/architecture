package ru.geekbrains.behavioralPatterns.visitor;

public class Lion {
    public void roar()
    {
        System.out.println("Roaaar!");
    }

    public void accept(AnimalOperation operation)
    {
        operation.visitLion(this);
    }
}

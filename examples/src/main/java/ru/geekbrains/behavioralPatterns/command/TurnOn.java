package ru.geekbrains.behavioralPatterns.command;

public class TurnOn implements Command{


    Bulb bulb;
    public TurnOn(Bulb bulb) {
        this.bulb = bulb;
    }


    public void execute()
    {
        this.bulb.turnOn();
    }

    public void undo()
    {
        this.bulb.turnOff();
    }

    public void redo()
    {
        this.execute();
    }
}

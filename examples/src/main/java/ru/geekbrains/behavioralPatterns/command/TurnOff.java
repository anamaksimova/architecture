package ru.geekbrains.behavioralPatterns.command;

public class TurnOff implements Command{
    Bulb bulb;
    public  TurnOff(Bulb bulb) {
        this.bulb = bulb;
    }

    public void execute()
    {
        this.bulb.turnOff();
    }

    public void undo()
    {
        this.bulb.turnOn();
    }

    public void redo()
    {
        this.execute();
    }
}

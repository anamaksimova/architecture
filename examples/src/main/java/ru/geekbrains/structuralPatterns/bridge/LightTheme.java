package ru.geekbrains.structuralPatterns.bridge;

public class LightTheme implements Theme{
    @Override
    public String getColour() {
        return "Off white";
    }
}

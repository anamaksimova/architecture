package ru.geekbrains.structuralPatterns.bridge;

public class DarkTheme implements Theme{
    @Override
    public String getColour() {
        return "Dark Black";
    }
}

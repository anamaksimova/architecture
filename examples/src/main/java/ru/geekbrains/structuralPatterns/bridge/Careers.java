package ru.geekbrains.structuralPatterns.bridge;

public class Careers implements WebPage{
    public Careers(Theme theme) {
        this.theme = theme;
    }

    Theme theme;


    @Override
    public String getContent() {
        return "Careers page in " + theme.getColour();
    }
}

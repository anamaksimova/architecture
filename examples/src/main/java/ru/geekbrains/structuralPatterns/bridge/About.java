package ru.geekbrains.structuralPatterns.bridge;

public class About implements WebPage{

    Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }



    @Override
    public String getContent() {
        return "About page in " + theme.getColour();
    }
}

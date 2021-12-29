package ru.geekbrains.mvp;

import java.util.ArrayList;
import java.util.List;

public class Variants {
   List<String> variants;


    public Variants() {
        variants = new ArrayList<>();
        variants.add("New friend");
        variants.add("Big Money");
        variants.add("Wedding");
        variants.add("Adventure");
        variants.add("Back to school");
        variants.add("Work work work");
        variants.add("Scandal");

        variants.add("Love");
        variants.add("See the ocean");
        variants.add("All the same");
    }
    public List<String> getVariants() {
        return variants;
    }





}

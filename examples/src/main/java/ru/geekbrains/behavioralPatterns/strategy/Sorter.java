package ru.geekbrains.behavioralPatterns.strategy;

import java.util.ArrayList;

public class Sorter {
    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    SortStrategy sorter;



    public int[] sort( int[] dataset)
    {
        return this.sorter.sort(dataset);
    }
}

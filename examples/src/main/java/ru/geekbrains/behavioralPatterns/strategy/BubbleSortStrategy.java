package ru.geekbrains.behavioralPatterns.strategy;

import java.util.ArrayList;

public class BubbleSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using bubble sort");

        // Do sorting
        return dataset;
    }
}

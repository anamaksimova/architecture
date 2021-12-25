package ru.geekbrains.behavioralPatterns.strategy;

import java.util.ArrayList;

public class QuickSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using quick sort");

        // Do sorting
        return dataset;
    }
}

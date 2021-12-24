package ru.geekbrains.structuralPatterns.composite;

public interface Employee {
    String getName();
    void   setSalary(float salary);
    Float  getSalary();
    String[] getRoles();
}

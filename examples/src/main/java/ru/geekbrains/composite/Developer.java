package ru.geekbrains.composite;

public class Developer implements Employee{


    String name;
    Float salary;
    String[] roles;
    public Developer(String name, Float salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String getName() {
     return this.name;
    }

    @Override
    public void setSalary(float salary) {
         this.salary=salary;
    }

    @Override
    public Float getSalary() {
        return this.salary;
    }

    @Override
    public String[] getRoles() {
        return this.roles;
    }
}

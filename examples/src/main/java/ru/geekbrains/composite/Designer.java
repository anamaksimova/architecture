package ru.geekbrains.composite;

public class Designer implements Employee{
    String name;
    Float salary;
    String[] roles;
    public Designer(String name, Float salary) {
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

package ru.geekbrains.composite;

import java.util.ArrayList;


public class Organization {

    public Organization(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    ArrayList<Employee> employees = new ArrayList<>();

    public Organization() {

    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    public float getNetSalaries(){

        float netSalary = 0;
        for (Employee emp:employees) {
            netSalary+=emp.getSalary();

        }

        return netSalary;}
    }

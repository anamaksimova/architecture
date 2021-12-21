package ru.geekbrains.decorator;

public class MilkCoffee implements Coffee{


    Coffee coffee;
    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public int getCost() {
        return this.coffee.getCost()+2;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription()+" milk ";
    }
}

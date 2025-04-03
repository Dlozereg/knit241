package org.knit.solutions.Task2_2_Classes;

public class Milk extends CoffeeDecorator{

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCalories() {
        return super.getCalories() + 20;
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}

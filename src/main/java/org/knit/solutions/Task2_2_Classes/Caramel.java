package org.knit.solutions.Task2_2_Classes;

public class Caramel extends CoffeeDecorator{
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCalories() {
        return super.getCalories() + 50;
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", карамель";
    }
}

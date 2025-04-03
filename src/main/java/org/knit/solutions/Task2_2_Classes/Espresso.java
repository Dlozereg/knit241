package org.knit.solutions.Task2_2_Classes;

public class Espresso implements Coffee{
    @Override
    public double getCalories() {
        return 100;
    }

    @Override
    public double getCost() {
        return 1.99;
    }

    @Override
    public String getDescription() {
        return "Эспрессо";
    }
}

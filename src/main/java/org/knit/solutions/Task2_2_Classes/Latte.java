package org.knit.solutions.Task2_2_Classes;

public class Latte implements Coffee{
    @Override
    public double getCalories() {
        return 130;
    }

    @Override
    public double getCost() {
        return 2.49;
    }

    @Override
    public String getDescription() {
        return "Латте";
    }
}


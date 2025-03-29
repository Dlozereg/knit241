package org.knit.solutions.Task2_11_Classes;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final String name;
    private double price;
    private List<StockObserver> observers;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        observers = new ArrayList<>();
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public String getName() {
        return name;
    }
}

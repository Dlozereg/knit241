package org.knit.solutions.Task2_8_Classes;

import java.util.concurrent.ThreadLocalRandom;

public class Intersection {
    private final Object lock = new Object();
    private String trafficLight = "красный";



    public void drive(String carName) {
        try {
            switch (trafficLight) {
                case "green" -> {
                    System.out.println("Машина " + carName + " проехала");
                    Thread.sleep(1000);
                }
                case "yellow" -> {
                    if (ThreadLocalRandom.current().nextInt(2) % 2 == 0) {
                        System.out.println("Машина " + carName + " проскочила");
                        Thread.sleep(1000);
                    } else {
                        synchronized (lock) {
                            lock.wait();
                            System.out.println("Машина " + carName + " проехала");
                            Thread.sleep(1000);
                        }
                    }
                }
                case "red" -> {
                    synchronized (lock) {
                        lock.wait();
                        System.out.println("Машина " + carName + " проехала");
                        Thread.sleep(1000);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeTrafficLight(String color) {
        switch (color) {
            case "green" -> {
                System.out.println("Зелёный сигнал");
                trafficLight = color;
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
            case "yellow" -> {
                System.out.println("Жёлтый сигнал");
                trafficLight = color;
            }
            case "red" -> {
                System.out.println("Красный сигнал");
                trafficLight = color;
            }
        }
    }
}

package org.knit.solutions.Task2_6_Classes;


public class LevelCrossing {
    protected boolean isTrainClose = false;
    private final Object lock = new Object();

    public void CarRoad(String carName) {
        try {
            if (isTrainClose) {
                synchronized (lock) {
                    lock.wait();
                }
            }
            System.out.println("Машина " + carName + " проехала");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void TrainRoad() {
        try {
            System.out.println("Поезд приближается!");
            isTrainClose = true;
            Thread.sleep(5000);
            System.out.println("Поезд проехал");
            isTrainClose = false;
            synchronized (lock) {
                lock.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

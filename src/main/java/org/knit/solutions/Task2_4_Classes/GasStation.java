package org.knit.solutions.Task2_4_Classes;

import java.util.concurrent.Semaphore;

public class GasStation {
    private static final Semaphore pump = new Semaphore(2);

    public static void Refuel(String carName) {
        try {
            pump.acquire();
            System.out.println(carName + " на заправке");
            Thread.sleep(2000);
            System.out.println(carName + " закончила заправляться");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            pump.release();
        }
    }
}

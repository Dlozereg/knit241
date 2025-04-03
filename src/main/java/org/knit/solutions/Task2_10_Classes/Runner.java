package org.knit.solutions.Task2_10_Classes;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Runner implements Runnable {
    private int runnerId;
    CyclicBarrier barrier;
    int speed;
    final int raceDistance;
    int distance = 0;
    AtomicBoolean isEveryoneAlive;

    public Runner(int runnerId, CyclicBarrier barrier, AtomicBoolean isEveryoneAlive) {
        this.runnerId = runnerId;
        this.barrier = barrier;
        this.isEveryoneAlive = isEveryoneAlive;
        speed = ThreadLocalRandom.current().nextInt(10, 50);
        raceDistance = 20000;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 4000));
            System.out.println("Бегун " + runnerId + " приготовился к старту");
            barrier.await();
            while (distance < raceDistance && isEveryoneAlive.get()) {
                Thread.sleep(500);
                distance += speed * 500;
                if (ThreadLocalRandom.current().nextInt(20) % 20 == 0) {
                    System.out.println("Бегун " + runnerId + " получил травму");
                    isEveryoneAlive.set(false);
                    barrier.reset();
                    throw new InterruptedException();
                }
            }
            if (isEveryoneAlive.get()) {
                System.out.println("Бегун " + runnerId + " финишировал");
                barrier.await();
            }
            else {
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.out.println("Бегун " + runnerId + " преждевременно остановился");
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

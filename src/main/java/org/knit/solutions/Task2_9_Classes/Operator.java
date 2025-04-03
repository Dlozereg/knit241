package org.knit.solutions.Task2_9_Classes;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Operator implements Runnable {
    private final BlockingQueue<Detail> assembleQueue;
    private final BlockingQueue<Detail> warehouseQueue;

    public Operator(BlockingQueue<Detail> assembleQueue, BlockingQueue<Detail> warehouseQueue) {
        this.assembleQueue = assembleQueue;
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = assembleQueue.poll(3000, TimeUnit.MILLISECONDS);
                if (detail != null) {
                    Thread.sleep(500);
                    System.out.println("checked detail" + detail.getId());
                    warehouseQueue.put(detail);
                }
                else {
                    System.out.println("Operator finished");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

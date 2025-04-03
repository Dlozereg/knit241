package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_6_Classes.LevelCrossing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 2.6 Задача «Железнодорожный переезд»
 * Описание:
 * Есть автомобили и поезд.
 *   * Если поезд приближается, машины останавливаются и ждут.
 *   * После того, как поезд проедет, машины продолжают движение.
 * Что нужно реализовать?
 * 1) Поток "Поезд" останавливает автомобили (wait()).
 * 2) Поток "Поезд" сообщает о завершении (notifyAll()).
 * 3) Машины ждут, если поезд едет, и продолжают движение после notifyAll().
 */

@TaskDescription(taskNumber = 6, taskDescription = "Задача «Железнодорожный переезд»")
public class Task2_6 implements Solution{
    @Override
    public void execute() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        LevelCrossing levelCrossing = new LevelCrossing();

        executor.submit(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(5000);
                    levelCrossing.TrainRoad();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        executor.submit(() -> {
            for (int i = 1; i <= 13; i++) {
                levelCrossing.CarRoad(Integer.toString(i) + "a");
            }
        });

        executor.submit(() -> {
            for (int i = 1; i <= 15; i++) {
                levelCrossing.CarRoad(Integer.toString(i) + "b");
            }
        });

        executor.shutdown();
    }
}

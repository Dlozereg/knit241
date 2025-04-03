package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_8_Classes.Intersection;

/*
 * 2.8 Задача «Перекресток: светофор и машины»
 * Описание:
 * На перекрестке светофор управляет движением:
 *   * Красный свет – машины стоят (wait()).
 *   * Зеленый свет – машины едут (notifyAll()).
 *   * Светофор переключается каждые 5 секунд.
 * Что нужно реализовать?
 * 1) Поток "Светофор" изменяет цвет и отправляет notifyAll().
 * 2) Потоки "Машина" ждут wait(), если красный свет.
 */

@TaskDescription(taskNumber = 8, taskDescription = "Задача «Перекресток: светофор и машины»")
public class Task2_8 implements Solution{
    @Override
    public void execute() {
        Intersection intersection = new Intersection();

        new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                try {
                    intersection.changeTrafficLight("yellow");
                    Thread.sleep(1500);
                    intersection.changeTrafficLight("green");
                    Thread.sleep(3000);
                    intersection.changeTrafficLight("yellow");
                    Thread.sleep(1500);
                    intersection.changeTrafficLight("red");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "TrafficLight").start();

        String[] paths = {"a", "b", "c", "d"};
        for (int i = 0; i < 4; i++) {
            String path = paths[i];
            new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    intersection.drive(Integer.toString(j) + path);
                }
            }, "Road " + path).start();
        }
    }
}

package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_7_Classes.Consumer;
import org.knit.solutions.Task2_7_Classes.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * 2.7 Задача «Производитель-Потребитель с ограничением»
 * Описание:
 *   * Производитель создает товары (максимум 5).
 *   * Потребитель забирает товары.
 *   * Если товаров нет, потребитель ждет (wait()).
 *   * Если товаров максимум, производитель ждет (wait()).
 * Что нужно реализовать?
 * 1) wait() – если товаров нет или склад заполнен.
 * 2) notify() – пробуждение потока, когда изменяется состояние склада.
 */

@TaskDescription(taskNumber = 7, taskDescription = "Задача «Производитель-Потребитель с ограничением»")
public class Task2_7 implements Solution{
    @Override
    public void execute() {
        BlockingQueue<String> itemStock = new ArrayBlockingQueue<>(5);

        new Thread(new Producer(itemStock)).start();
        new Thread(new Consumer(itemStock)).start();
    }
}

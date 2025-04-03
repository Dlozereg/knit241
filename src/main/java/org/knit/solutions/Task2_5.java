package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_5_Classes.Cook;
import org.knit.solutions.Task2_5_Classes.Waiter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * 2.5 Задача «Ресторан: Повар и Официант»
 * Описание:
 * В ресторане работает один повар и один официант.
 *   * Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
 *   * Официант берет готовые блюда и подает их клиентам.
 * Что нужно реализовать?
 * 1) Повар не может готовить больше 3 блюд (ждет wait()).
 * 2) Официант ждет, если поднос пуст (wait()).
 * 3) При каждой передаче блюда используется notify().
 */

@TaskDescription(taskNumber = 5, taskDescription = "Задача «Ресторан: Повар и Официант»")
public class Task2_5 implements Solution{
    @Override
    public void execute() {
        BlockingQueue<String> dishes = new ArrayBlockingQueue<>(3);

        new Thread(new Cook(dishes)).start();
        new Thread(new Waiter(dishes)).start();
    }
}

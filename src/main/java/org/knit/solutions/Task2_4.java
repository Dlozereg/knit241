package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_4_Classes.GasStation;

/*
 * 2.4 Задача «Автозаправочная станция»
 * Описание:
 * На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
 * Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.
 *
 * Что нужно реализовать?
 * 1) Использовать wait() и notify() для ожидания и освобождения заправки.
 * 2) Поток "Машина" ждет, если все колонки заняты.
 * 3) Поток "Машина" заправляется, затем освобождает колонку.
 */

@TaskDescription(taskNumber = 4, taskDescription = "Задача «Автозаправочная станция»")
public class Task2_4 implements Solution{
    @Override
    public void execute() {
        for (int i = 1; i <= 10; i++){
            new Thread(() -> GasStation.Refuel(Thread.currentThread().getName()), "Машина " + i).start();
        }
    }
}

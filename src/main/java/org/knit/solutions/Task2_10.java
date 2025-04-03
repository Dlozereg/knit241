package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_10_Classes.Runner;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* Задача 10: Гонка бегунов с использованием CyclicBarrier
 * Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
 * Как только все участники будут готовы, забег начнётся одновременно. Используйте CyclicBarrier,
 * чтобы синхронизировать запуск гонки.
 * Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep),
 * после чего финиширует. Как только все бегуны завершат дистанцию, программа выводит сообщение о
 * завершении гонки.
 * Требования к задаче:
 * 1) Создать CyclicBarrier для синхронизации начала забега.
 * 2) Реализовать класс Runner, который будет выполнять следующую логику в потоке:
 *   * Ожидание старта (использование barrier.await()).
 *   * Симуляция бега (Thread.sleep(randomTime)).
 *   * Вывод сообщения о финише.
 * 3) После финиша всех участников программа должна сообщить, что гонка завершена.
 * 4) Количество бегунов передаётся в аргументах командной строки или задаётся константой.
 */

/*
 * RUNNERSCOUNT бегунов готовяться к старту, после чего начинается забег. На финише все бегуны
 * дожидаются окончания гонки.
 */

@TaskDescription(taskNumber = 10, taskDescription = "Задача 10: Гонка бегунов с использованием CyclicBarrier")
public class Task2_10 implements Solution{
    static final int RUNNERSCOUNT = 5;

    @Override
    public  void execute() {

        AtomicBoolean runstarted = new AtomicBoolean(false);
        AtomicBoolean isEveryoneAlive = new AtomicBoolean(true);

        CyclicBarrier barrier = new CyclicBarrier(RUNNERSCOUNT, () -> {
            if (!runstarted.get()) {
                System.out.println("Старт забега");
                runstarted.set(true);
            }
            else {
                System.out.println("Конец забега");
                runstarted.set(false);
            }
        });
        try (ExecutorService executor = Executors.newFixedThreadPool(RUNNERSCOUNT)) {
            for (int i = 1; i <= RUNNERSCOUNT; i++) {
                executor.submit(new Runner(i, barrier, isEveryoneAlive));
            }
            executor.shutdown();
        }

    }
}

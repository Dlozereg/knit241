package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_9_Classes.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 2.9 Задача «Конвейер сборки деталей»
 * Описание задачи
 * На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
 * 1) Штамповщик – вырезает заготовку (создает объект детали).
 * 2) Сборщик – собирает из заготовки готовую деталь.
 * 3) Оператор контроля качества – проверяет деталь и отправляет на склад.
 * Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
 *
 * Требования к решению
 *   * Использовать потоки (Thread или ExecutorService).
 *   * Использовать синхронизацию (wait(), notify(), BlockingQueue).
 *   * Реализовать конвейерную передачу данных между потоками.
 */

@TaskDescription(taskNumber = 9, taskDescription = "Задача «Конвейер сборки деталей»")
public class Task2_9 implements Solution{
    @Override
    public void execute() {
        BlockingQueue<Detail> stampingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> assembleQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> warehouseQueue = new LinkedBlockingQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Stamper(stampingQueue));
        executor.submit(new Assembler(stampingQueue, assembleQueue));
        executor.submit(new Operator(assembleQueue, warehouseQueue));
        executor.shutdown();
    }
}

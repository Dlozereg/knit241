package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Задача № 18
 * Условие задачи:
 * Дан массив целых чисел arr фиксированной длины. Необходимо продублировать каждое вхождение нуля,
 * сдвигая остальные элементы вправо.
 *
 * Примечание:
 * 1) Элементы, выходящие за пределы исходного массива, не записываются.
 * 2) Изменения нужно выполнить на месте (in-place), не возвращая новый массив.
 *
 * Ограничения:
 * 1) 1 <= arr.length <= 10^4
 * 2) 0 <= arr[i] <= 9
 *
 * Напишите решение, а затем напишите JUnit тесты для проверки решения
 * Тесты должны покрывать
 * --Обычные случаи (с нулями и без).
 * --Краевые случаи (пустые массивы, все нули, нули на границах).
 * --Производительность (большие массивы). // просто зафиксировать время выполнения по производительности
 * эмпирическим путем
 */
@TaskDescription(taskNumber = 18, taskDescription = "Задача № 18 JUnit тесты")
public class Task2_18 implements Solution {
    @Override
    public void execute() {
        System.out.println("JUnit tests");
    }

    public void duplicateZeros(int[] arr) {
        Queue<Integer> numbersQueue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numbersQueue.add(0);
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == 0) {
                        numbersQueue.add(0);
                        numbersQueue.add(0);
                    }
                    else {
                        numbersQueue.add(arr[j]);
                    }
                    arr[j] = numbersQueue.remove();
                }
                break;
            }
        }
    }
}

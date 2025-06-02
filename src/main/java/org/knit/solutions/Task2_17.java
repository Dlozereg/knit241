package org.knit.solutions;

import org.knit.TaskDescription;

import java.util.ArrayList;
import java.util.Random;

/*
 * Задача 17: Реализация и проверка парадокса Монти Холла
 * Описание:
 * Парадокс Монти Холла — это задача из теории вероятностей, основанная на популярном шоу "Let's Make a Deal".
 * Правила такие:
 * 1) Участник выбирает одну из трёх дверей.
 * 2) Ведущий, который знает, что за дверями, открывает одну из оставшихся дверей, за которой нет приза.
 * 3) Участнику предлагается либо сменить выбор на оставшуюся дверь, либо оставить свой выбор неизменным.
 *
 * Вопрос:
 * * Реализуйте симуляцию этой игры на Java, чтобы проверить,
 * * что лучше: менять выбор или оставаться при своём?.
 * * Программа должна провести большое количество экспериментов (например, 1000000)
 * и показать вероятность выигрыша в каждом из двух случаев.
 *
 * Ожидаемый результат:
 * При достаточно большом количестве игр (например, 1 миллион):
 * * Вероятность выигрыша при переключении: около 66.66% (или 2/3).
 * * Вероятность выигрыша без переключения: около 33.33% (или 1/3).
 */
@TaskDescription(taskNumber = 17, taskDescription = "Задача 17: Реализация и проверка парадокса Монти Холла")
public class Task2_17 implements Solution {
    @Override
    public void execute() {
        Random rnd = new Random();
        double stayTimesWon = 0;
        double switchTimesWon = 0;
        for (int i = 0; i < 1000000; i++) {
            ArrayList<Integer> doorsToChoose = new ArrayList<>(3);
            doorsToChoose.add(1);
            doorsToChoose.add(2);
            doorsToChoose.add(3);
            ArrayList<Integer> doorsToOpen = new ArrayList<>(doorsToChoose);

            // Выбирается случайная дверь, за которой будет приз.
            // Эта дверь убирается из дверей, которые может открыть ведущий
            int prize = rnd.nextInt(1, 4);
            doorsToOpen.remove(Integer.valueOf(prize));

            // Участник выбирает, какую дверь он хочет открыть.
            // Эту дверь ведущий также не может открыть
            // (проверка нужна на случай если участник выбрал ту же дверь, за которой приз)
            int choice = rnd.nextInt(1, 4);
            if (doorsToOpen.contains(choice)) {
                doorsToOpen.remove(Integer.valueOf(choice));
            }

            // Ведущий открывает одну из дверей, на выбор участнику остаются две другие
            doorsToChoose.remove(doorsToOpen.get(rnd.nextInt(doorsToOpen.size())));

            // 1 участник не изменяет выбор,
            // 2 участник меняет выбор на другую дверь
            int sameChoice = choice;
            int switchChoice = (doorsToChoose.get(0) == choice)? doorsToChoose.get(1): doorsToChoose.get(0);

            // подводятся итоги, кто из участников выиграл
            // (можно было через if-else, но так немного нагляднее)
            if (sameChoice == prize) { stayTimesWon += 1; }
            if (switchChoice == prize) { switchTimesWon += 1; }
        }
        System.out.printf("Вероятность выиграть, не меняя выбор: %f%n", stayTimesWon/1000000);
        System.out.printf("Вероятность выиграть, изменяя выбор: %f%n", switchTimesWon/1000000);
    }
}

package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_2_Classes.*;

/*
 * Задача 2.2 Decorator (Декоратор)
 * Задача:
 * Реализуйте систему онлайн-заказов кофе.
 *
 * 1) У вас есть базовый класс Coffee, который имеет метод getCost() и getDescription().
 * 2) Напишите декораторы для добавления различных ингредиентов (молоко, карамель, шоколад).
 * 3) Каждый декоратор изменяет стоимость и описание кофе.
 * 4) Расширьте решение, добавив калорийность и разные виды напитков
 */

@TaskDescription(taskNumber = 2, taskDescription = "Decorator (Декоратор)")
public class Task2_2 implements Solution{
    @Override
    public void execute(){
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDescription() + " | Цена: $" + espresso.getCost() + " | Калорийность: " + espresso.getCalories() + " ккал");

        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription() + " | Цена: $" + espresso.getCost() + " | Калорийность: " + espresso.getCalories() + " ккал");

        Coffee cappuccino = new Cappuccino();
        System.out.println(cappuccino.getDescription() + " | Цена: $" + cappuccino.getCost() + " | Калорийность: " + cappuccino.getCalories() + " ккал");

        cappuccino = new Caramel(cappuccino);
        System.out.println(cappuccino.getDescription() + " | Цена: $" + cappuccino.getCost() + " | Калорийность: " + cappuccino.getCalories() + " ккал");

        Coffee latte = new Latte();
        System.out.println(latte.getDescription() + " | Цена: $" + latte.getCost() + " | Калорийность: " + latte.getCalories() + " ккал");

        latte = new Chocolate(latte);
        System.out.println(latte.getDescription() + " | Цена: $" + latte.getCost() + " | Калорийность: " + latte.getCalories() + " ккал");
    }
}

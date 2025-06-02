package org.knit.solutions;

import org.knit.TaskDescription;

/*
 * Лабораторная работа часть 2 № 9 Задача 22
Тема: Создание REST API для отображения координат, времени и временных зон городов мира
8 баллов
Цель работы

Закрепить навыки создания REST-приложения на Spring Boot:

    Работа с чтением данных из файла
    Создание сервисного слоя
    Работа с датами, часовыми поясами
    Создание контроллеров
    Тестирование API через Postman или curl

Ход работы
Шаг 1. Подготовка проекта

    Использовать проект с прошлого задания или создать новый аналогичным способом.
    В папке src/main/resources создать файл cities.csv со следующей структурой:

Шаг 2. Модель данных
Создайте новый класс:

Шаг 3. Сервис для загрузки данных
Создайте сервис для чтения файла и расчёта времени:

Шаг 4. Создание REST-контроллера

Шаг 5. Тестирование через Postman или curl

Примеры запросов:

    Все города:

GET http://localhost:8080/api/cities

    Один город по имени:

GET http://localhost:8080/api/cities/Moscow

Пример ответа для одного города:

{
  "city": "Moscow",
  "country": "Russia",
  "latitude": 55.7558,
  "longitude": 37.6176,
  "timezone": "Europe/Moscow",
  "localTime": "2025-04-25 22:40:13",
  "utcTime": "2025-04-25T18:40:13Z"
}
 */
@TaskDescription(taskNumber = 22, taskDescription = "Задание 22: Создание REST API для отображения координат, времени и временных зон городов мира")
public class Task2_22 implements Solution {
    @Override
    public void execute() {
        System.out.println("Ссылка на проект: https://github.com/Dlozereg/Lab_2_9.git");
    }
}

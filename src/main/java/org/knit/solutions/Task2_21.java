package org.knit.solutions;

import org.knit.TaskDescription;

/*
 * Лабораторная работа часть 2 № 8 Задача 21
 * Тема: Создание REST-приложения на Spring Boot. Работа с Git и Postman
 * 8 баллов
 * Цель работы
 * * Познакомиться с созданием Spring Boot проекта, реализацией простого REST-контроллера,
 * использованием системы контроля версий Git и тестированием HTTP-запросов с помощью Postman.
 * Ход работы
Шаг 1. Генерация Spring Boot проекта

    Перейдите на сайт https://start.spring.io.
    Укажите следующие параметры:
        Project: Maven
        Language: Java
        Spring Boot: версия по умолчанию
        Project Metadata:
            Group: com.example
            Artifact: demo
        Dependencies:
            Spring Web
            Lombok
    Нажмите Generate, чтобы скачать архив проекта.
    Распакуйте его на компьютере.

Шаг 2. Открытие проекта в IntelliJ IDEA и настройка Git
Откройте IntelliJ IDEA.
Выберите File → Open и укажите папку с распакованным проектом.
Убедитесь, что установлен JDK 17:

    File → Project Structure → Project → Project SDK → выбрать JDK 17

Инициализация Git:

    Откройте Terminal (Alt + F12).
    Выполните команду:

    git init

Создайте файл .gitignore, добавьте в него:

target/
.idea/
*.iml

Добавьте файлы под контроль версий:

git add .
git commit -m "Initial commit"

(По желанию) создайте репозиторий на GitHub и свяжите его:

git remote add origin https://github.com/your-username/your-repo.git
git branch -M main
git push -u origin main

Шаг 3. Создание простого REST-контроллера
Создайте новый класс в папке src/main/java/com/example/demo/controller/

Шаг 4. Работа с Postman

Установите Postman: https://www.postman.com/downloads/

Запустите приложение.

Тестирование GET-запроса:

    Метод: GET
    URL: http://localhost:8080/api/hello
    Нажмите Send
    Ожидаемый ответ: Привет, мир!

Тестирование POST-запроса:

    Метод: POST
    URL: http://localhost:8080/api/echo
    Body → raw → JSON:

    {
      "text": "Это тест"
    }

Нажмите Send
Ожидаемый ответ:

{
  "text": "Это тест"
}
 */
@TaskDescription(taskNumber = 21, taskDescription = "Задание 21: Создание REST-приложения на Spring Boot. Работа с Git и Postman")
public class Task2_21 implements Solution {
    @Override
    public void execute() {
            System.out.println("Ссылка на проект: https://github.com/Dlozereg/Lab_2_8.git");
    }
}

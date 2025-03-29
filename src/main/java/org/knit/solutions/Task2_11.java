package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_11_Classes.EmailNotifier;
import org.knit.solutions.Task2_11_Classes.MobileApp;
import org.knit.solutions.Task2_11_Classes.Stock;

/*
 * Паттерн Observer (Наблюдатель)
 * Задача 11: Реализация системы уведомлений в биржевом приложении
 * Вы разрабатываете приложение для биржевой торговли,
 * где пользователи могут подписываться на обновления акций определённых компаний.
 *
 * Требуется:
 * 1) Создать класс Stock (акция), который хранит информацию о текущей цене и
 * может уведомлять подписчиков об изменении цены.
 * 2) Создать интерфейс StockObserver и реализовать его в классах MobileApp и
 * EmailNotifier, которые получают уведомления при изменении цены.
 * 3) Реализовать механизм подписки и отписки для StockObserver.
 *
 * Пример работы:
 * 1) Пользователь подписывается на акции компании "Tesla".
 * 2) Когда цена акции изменяется, приложение отправляет уведомления подписчикам.
 * 3) Если пользователь отписался, он больше не получает уведомления.
 * Дополнительно: Добавьте возможность подписки на акции нескольких компаний.
 */

@TaskDescription(taskNumber = 11, taskDescription = "Паттерн Observer (Наблюдатель), реализация системы уведомлений в биржевом приложении")
public class Task2_11 implements Solution {
    @Override
    public void execute() {
        Stock google = new Stock("Google", 10);
        Stock microsoft = new Stock("Microsoft", 9);

        MobileApp mobileApp = new MobileApp();
        EmailNotifier emailNotifier = new EmailNotifier();

        mobileApp.getSubscriptions();
        System.out.println();

        mobileApp.subscribe(google);
        emailNotifier.subscribe(google);
        emailNotifier.subscribe(microsoft);

        google.setPrice(15.5);
        microsoft.setPrice(11.2);
        System.out.println();

        emailNotifier.unsubscribe(google);

        google.setPrice(18.9);
        microsoft.setPrice(14.4);
        System.out.println();
    }
}

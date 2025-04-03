package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_3_Classes.Transport;
import org.knit.solutions.Task2_3_Classes.TransportFactory;

/*
 * 2.3 Factory (Фабрика)
 * Задача:
 * Реализуйте фабрику по созданию различных видов транспортных средств в системе каршеринга.
 *
 * 1) Создайте интерфейс Transport с методом getSpecifications(), который возвращает характеристики
 *  транспортного средства.
 * 2) Создайте классы BusinessCar, FamilyVan и Motorbike, реализующие Transport.
 *    * BusinessCar должен иметь комфортный салон и кожаные сиденья.
 *    * FamilyVan должен поддерживать перевозку 6+ пассажиров.
 *    * Motorbike предназначен для быстрой доставки.
 * 3) Создайте класс TransportFactory, который:
 *    * Принимает параметр типа поездки ("business", "family", "delivery").
 *    * Возвращает соответствующий объект (BusinessCar, FamilyVan, Motorbike).
 * 4) Добавьте обработку исключений, если передан неизвестный тип транспорта.
 * 5) Вызов TransportFactory.createTransport("business") должен возвращать объект BusinessCar.
 */

@TaskDescription(taskNumber = 3, taskDescription = "Factory (Фабрика)")
public class Task2_3 implements Solution{
    @Override
    public void execute(){
        Transport businessCar = TransportFactory.createTransport("business");
        System.out.println(businessCar.getSpecifications().toString());
        Transport familyCar = TransportFactory.createTransport("family");
        System.out.println(familyCar.getSpecifications().toString());
        Transport motorbike = TransportFactory.createTransport("delivery");
        System.out.println(motorbike.getSpecifications().toString());
        Transport Car = TransportFactory.createTransport("car");
    }
}

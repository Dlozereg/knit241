package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_13_Classes.*;

/**
 * Паттерн Command (Команда)
 * Задача 13: Реализация системы команд для управления умным домом
 *
 * Вы разрабатываете систему управления "умным домом", где пользователь может
 * выполнять различные команды, такие как включение/выключение света, управление
 * телевизором и кондиционером.
 *
 * Требуется:
 *
 * 1) Создать интерфейс Command, который определяет метод execute().
 * 2) Реализовать классы команд:
 * 3) LightOnCommand – включает свет.
 * 4) LightOffCommand – выключает свет.
 * 5) TVOnCommand – включает телевизор.
 * 6) TVOffCommand – выключает телевизор.
 * 7) Создать класс RemoteControl, который хранит команду и позволяет её выполнить.
 * 8) Реализовать механизм отмены последней команды (undo).
 * Пример работы:
 *
 * 1) Пользователь нажимает кнопку "Включить свет" – выполняется LightOnCommand.
 * 2) Затем нажимает "Выключить телевизор" – выполняется TVOffCommand.
 * 3) Пользователь нажимает "Отменить последнюю команду" – телевизор снова включается.
 * Дополнительно (не реализовано): Реализуйте поддержку макрокоманд (например,
 * кнопка "Спокойной ночи" выключает все приборы разом).
 */
@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда), реализация системы команд для управления умным домом")
public class Task2_13 implements Solution {
    @Override
    public void execute() {
        TV tv = new TV();
        Lamp lamp = new Lamp();

        LightsOnCommand lightsOnCommand = new LightsOnCommand(lamp);
        LightsOffCommand lightsOffCommand = new LightsOffCommand(lamp);
        lightsOnCommand.setReverseCommand(lightsOffCommand);
        lightsOffCommand.setReverseCommand(lightsOnCommand);

        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);
        tvOnCommand.setReverseCommand(tvOffCommand);
        tvOffCommand.setReverseCommand(tvOnCommand);

        RemoteControl remoteControl = new RemoteControl();

        System.out.println("execute lights on");
        remoteControl.executeCommand(lightsOnCommand);

        System.out.println("undo last command");
        remoteControl.undo();

        System.out.println("undo last command");
        remoteControl.undo();

        System.out.println("execute lights off");
        remoteControl.executeCommand(lightsOffCommand);

        System.out.println("execute tv on");
        remoteControl.executeCommand(tvOnCommand);

        System.out.println("undo last command");
        remoteControl.undo();
    }
}

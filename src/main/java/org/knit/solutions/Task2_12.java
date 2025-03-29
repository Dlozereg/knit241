package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_12_Classes.Caretaker;
import org.knit.solutions.Task2_12_Classes.TextEditor;

/**
 * Паттерн Memento (Хранитель)
 * Задача 12: Реализация системы отмены изменений в текстовом редакторе
 * Разработайте систему, позволяющую сохранять состояния текста в редакторе и
 * откатывать изменения назад.
 *
 * Требуется:
 * 1) Создать класс TextEditor, который содержит текущий текст документа.
 * 2) Создать класс Memento, который будет хранить снимок состояния текста.
 * 3) Реализовать Caretaker, который управляет историей изменений (например,
 * стек сохранённых состояний).
 * 4) Реализовать методы saveState() и undo() для сохранения и отката изменений.
 *
 * Пример работы:
 *
 * 1) Пользователь вводит текст "Hello, world!".
 * 2) Он сохраняет текущее состояние.
 * 3) Затем добавляет " How are you?".
 * 4) Нажимает "Отменить" и возвращается к "Hello, world!".
 * Дополнительно: Реализуйте возможность нескольких уровней отката.
 */
@TaskDescription(taskNumber = 12, taskDescription = "Паттерн Memento (Хранитель), реализация системы отмены изменений в текстовом редакторе")
public class Task2_12 implements Solution {
    @Override
    public void execute() {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker(textEditor);

        textEditor.write("Hello");
        textEditor.show();
        caretaker.saveState();

        textEditor.write(" world");
        textEditor.show();

        caretaker.undo();
        textEditor.show();
    }
}

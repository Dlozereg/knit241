package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_16_Classes.Canvas;
import org.knit.solutions.Task2_16_Classes.Character;
import org.knit.solutions.Task2_16_Classes.CharacterFactory;


/**
 * Задача 16 на паттерн Приспособленец (Flyweight)
 * Задача:
 * Реализуйте систему отображения символов текста на экране.
 * 1) Каждый символ (Character) имеет внутреннее состояние (код символа) и внешнее состояние (координаты x, y и стиль).
 * 2) Используйте Фабрику приспособленцев, чтобы повторно использовать объекты символов и уменьшить количество объектов, создаваемых в системе.
 *
 * Подсказка:
 * Внешнее состояние передается в метод render(), а внутреннее хранится внутри объектов, создаваемых фабрикой.
 */
@TaskDescription(taskNumber = 16, taskDescription = "Задача на паттерн Приспособленец (Flyweight)")
public class Task2_16 implements Solution {
    @Override
    public void execute() {
        Canvas canvas = new Canvas(5);
        Character ch1 = CharacterFactory.getCharacter(72);
        Character ch2 = CharacterFactory.getCharacter(101);
        Character ch3 = CharacterFactory.getCharacter(108);
        Character ch4 = CharacterFactory.getCharacter(108);
        Character ch5 = CharacterFactory.getCharacter(111);

        Character ch6 = CharacterFactory.getCharacter(119);
        Character ch7 = CharacterFactory.getCharacter(111);
        Character ch8 = CharacterFactory.getCharacter(114);
        Character ch9 = CharacterFactory.getCharacter(108);
        Character ch10 = CharacterFactory.getCharacter(100);
        Character ch11 = CharacterFactory.getCharacter(33);

        ch1.render(canvas, 1, 1, "bolditalics"); // "H"
        ch2.render(canvas, 2, 1); // "e"
        ch3.render(canvas, 3, 1, "bold"); // "l"
        ch4.render(canvas, 4, 1); // "l"
        ch5.render(canvas, 5, 1); // "o"

        ch6.render(canvas, 0, 3, "italics"); // "w" out of boundaries
        ch7.render(canvas, 1, 3); // "o"
        ch8.render(canvas, 2, 3); // "r"
        ch9.render(canvas, 3, 3); // "l"
        ch10.render(canvas, 4, 3); // "d"
        ch11.render(canvas, 5, 3, "cross"); // "!" non-existing style

        canvas.Show();
    }
}

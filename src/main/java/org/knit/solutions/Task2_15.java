package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_15_Classses.*;


/**
 * Задача 15 на паттерн Прокси (Proxy)
 * Задача:
 * Создайте удаленную библиотеку изображений.
 * 1) При запросе изображения оно загружается с сервера (имитация через задержку в коде).
 * 2) Картинка хранится как объект класса RealImage.
 * 3) Прокси-объект ImageProxy должен лениво загружать изображение и кэшировать его для повторного использования.
 *
 * Подсказка:
 * ImageProxy должен проверять, создан ли объект RealImage. Если нет — создавать его.
 */
@TaskDescription(taskNumber = 15, taskDescription = "Задача на паттерн Прокси (Proxy)")
public class Task2_15 implements Solution {
    @Override
    public void execute() {
        Image image1 = new ImageProxy("bill");
        Image image2 = new ImageProxy("mike");
        image1.Show();
        image1.Show();
        image2.Show();
        image2.Show();
        image1.Show();
    }
}

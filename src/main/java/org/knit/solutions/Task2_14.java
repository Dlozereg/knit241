package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2_14_Classes.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Задача 14 на паттерн Визитер (Visitor)
 * Создайте систему управления файловыми объектами.
 *
 * Есть три типа файловых объектов:
 * 1) Файлы,
 * 2) Папки,
 * 3) Ссылки (ярлыки).
 *
 * Требуется реализовать два посетителя:
 * 1) Сканер вирусов, который проверяет каждый файл на наличие вирусов.
 * 2) Анализатор размера, который подсчитывает общий размер файлов (ссылки не учитываются).
 * Подсказка:
 * Каждый файл, папка и ссылка должны реализовывать интерфейс FileSystemElement.
 * В accept() методе вызывается соответствующий метод визитера.
 */
@TaskDescription(taskNumber = 14, taskDescription = "Задача на паттерн Визитер (Visitor)")
public class Task2_14 implements Solution {
    @Override
    public void execute() {
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();
        VirusScanner virusScanner = new VirusScanner();

        Folder folder1 = new Folder("folder 1");

        System.out.println("Сканируем пустую папку:");
        sizeAnalyzer.analyze(folder1);
        System.out.println();
        virusScanner.scan(folder1);
        System.out.println();

        File file1 = new File("empty file");
        File file2 = new File("safe file");
        file2.setContent("there is no threats");
        File file3 = new File("virus file");
        file3.setContent("thisfilehasavirus");
        folder1.addAllElements(new ArrayList<>(Arrays.asList(file1, file2, file3)));

        System.out.println("Сканирование папки с 3-мя файлами:");
        sizeAnalyzer.analyze(folder1);
        System.out.println();
        virusScanner.scan(folder1);
        System.out.println();

        Folder folder2 = new Folder("folder 2");
        File file4 = new File("virus file2");
        file4.setContent("alsohasavirus");
        folder2.addElement(file4);
        Shortcut shortcut1 = new Shortcut("safe shortcut", file2);
        folder2.addElement(shortcut1);
        Shortcut shortcut2 = new Shortcut("virus shortcut", file4);
        folder2.addElement(shortcut2);
        Shortcut shortcut3 = new Shortcut("recursive folder shortcut", folder2);
        folder2.addElement(shortcut3);
        folder1.addElement(folder2);

        System.out.println("Сканирование папок, файлов и ярлыков:");
        sizeAnalyzer.analyze(folder1);
        System.out.println();
        virusScanner.scan(folder1);

    }
}

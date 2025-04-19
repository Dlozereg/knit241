package org.knit.solutions.Task2_14_Classes;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class VirusScanner implements Visitor {
    private int totalViruses = 0;
    private int totalScanned = 0;
    private Set<FileSystemElement> scannedElements = new HashSet<>();

    @Override
    public void visit(File file) {
        if (file.getContent() != null && file.getContent().contains("virus")) {
            System.out.println("found virus in file: " + file.getName());
            totalViruses += 1;
        }
        scannedElements.add(file);
        totalScanned += 1;
    }

    @Override
    public void visit(Folder folder) {
        scannedElements.add(folder);
        List<FileSystemElement> elements = folder.getElements();
        for (FileSystemElement element: elements) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        // Может ли антивирус сканировать файл, указаный в ярлыке? Что если в его место хранения
        // антивирусу заходить нельзя?
        FileSystemElement element = shortcut.getElement();
        if (!scannedElements.contains(element)) {
            element.accept(this);
        }
        totalScanned += 1;
    }

    public void scan(FileSystemElement fileSystemElement) {
        fileSystemElement.accept(this);
        System.out.println("-------------------------");
        System.out.println("Scanned items: " + totalScanned);
        if (totalViruses == 0) {
            System.out.println("No viruses found");
        }
        else {
            System.out.println("Found viruses: " + totalViruses);
        }
        totalScanned = 0;
        totalViruses = 0;
        scannedElements.clear();
    }
}

package org.knit.solutions.Task2_14_Classes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SizeAnalyzer implements Visitor {
    // private final Map<String, Integer> analyzedElements = new LinkedHashMap<String, Integer>();
    private int totalKB = 0;

    @Override
    public void visit(File file) {
        // analyzedElements.put(file.getName(), file.getSizeKB());
        totalKB += file.getSizeKB();
    }

    @Override
    public void visit(Folder folder) {
        List<FileSystemElement> elements = folder.getElements();
        // analyzedElements.put(folder.getName(), folder.getSizeKB());
        totalKB += folder.getSizeKB();
        for (FileSystemElement element: elements) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        // analyzedElements.put(shortcut.getName(), shortcut.getSizeKB());
        totalKB += shortcut.getSizeKB();
    }

    public void analyze(FileSystemElement fileSystemElement) {
        fileSystemElement.accept(this);
        System.out.println("total size: " + totalKB);
        totalKB = 0;
    }
}

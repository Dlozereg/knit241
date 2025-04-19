package org.knit.solutions.Task2_14_Classes;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemElement {
    private String name;
    private final int sizeKB = 0;
    private final List<FileSystemElement> elements = new ArrayList<>();


    public Folder(String name) {
        this.name = name;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public void addAllElements(List<FileSystemElement> elements) {
        this.elements.addAll(elements);
    }

    public void removeElement(FileSystemElement element) {
        elements.remove(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeKB() {
        return sizeKB;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }
}

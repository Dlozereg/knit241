package org.knit.solutions.Task2_14_Classes;

public class Shortcut implements FileSystemElement {
    private String name;
    private final int sizeKB = 1;
    private final FileSystemElement element;

    public Shortcut(String name, FileSystemElement element) {
        this.name = name;
        if (element instanceof Shortcut) {
            throw new IllegalArgumentException("Can't create a shortcut for a shortcut");
        }
        else {
            this.element = element;
        }
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

    public FileSystemElement getElement() {
        return element;
    }
}

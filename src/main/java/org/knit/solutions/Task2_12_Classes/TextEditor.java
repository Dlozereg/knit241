package org.knit.solutions.Task2_12_Classes;

public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void write(String text) {
        this.text.append(text);
    }

    public void show() {
        System.out.println(text);
    }

    public Memento saveState() {
        return new Memento(text.toString());
    }

    public void restore(Memento prevstate) {
        text = new StringBuilder(prevstate.getSavedText());
    }
}

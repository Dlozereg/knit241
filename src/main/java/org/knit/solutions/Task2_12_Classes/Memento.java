package org.knit.solutions.Task2_12_Classes;

public class Memento {
    private String savedText;

    public Memento(String text) {
        savedText = text;
    }

    public String getSavedText() {
        return savedText;
    }
}

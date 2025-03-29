package org.knit.solutions.Task2_12_Classes;

public class Caretaker {
    private TextEditor textEditor;
    private Memento prevState;

    public Caretaker(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void saveState() {
        prevState = textEditor.saveState();
    }

    public void undo() {
        textEditor.restore(prevState);
    }
}

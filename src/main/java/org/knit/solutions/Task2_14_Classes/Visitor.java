package org.knit.solutions.Task2_14_Classes;

public interface Visitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Shortcut shortcut);
}

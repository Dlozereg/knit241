package org.knit.solutions.Task2_16_Classes;

import java.util.Arrays;

public class Canvas {
    private final String[][] canvas;

    public Canvas(int size) {
        canvas = new String[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(canvas[i], " ");
        }
    }

    public void addSymbol(String symbol, int i, int j) {
        try {
            canvas[i][j] = symbol;
        } catch (Exception ignored) {}
    }

    public void Show() {
        for (String[] line : canvas) {
            System.out.println(String.join(" ", line));
        }
    }
}

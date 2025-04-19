package org.knit.solutions.Task2_16_Classes;

public class Character {
    private final int symbolCode;

    public Character(int symbolCode) {
        this.symbolCode = symbolCode;
    }

    public void render(Canvas canvas, int x, int y, String style) {
        String symbol;

        switch (style) {
            case "bold":
                symbol = "*" + ((char)symbolCode) + "*";
                break;
            case "italics":
                symbol = "_" + ((char)symbolCode) + "_";
                break;
            case "bolditalics":
                symbol = "*_" + ((char)symbolCode) + "*_";
                break;
            default:
                symbol = "";
                break;
        }

        if (!symbol.isEmpty()) {
            canvas.addSymbol(symbol, y - 1, x - 1);
        }
    }

    public void render(Canvas canvas, int x, int y) {
        canvas.addSymbol(String.valueOf((char)symbolCode), y - 1, x - 1);
    }
}

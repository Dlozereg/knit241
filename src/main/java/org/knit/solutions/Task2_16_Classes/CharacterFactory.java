package org.knit.solutions.Task2_16_Classes;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static final Map<Integer, Character> uniqChars = new HashMap<>();

    public static Character getCharacter(int symbolCode) {
        if (uniqChars.containsKey(symbolCode)) {
            return uniqChars.get(symbolCode);
        }
        Character ch = new Character(symbolCode);
        uniqChars.put(symbolCode, ch);
        return ch;
    }
}

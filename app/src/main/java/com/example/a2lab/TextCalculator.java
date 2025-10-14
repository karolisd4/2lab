package com.example.a2lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCalculator {
    public int countSentences(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] sentences = text.split("[.!?]+");
        return sentences.length;
    }

    public int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public int countSymbols(String text) {
        if (text == null || text.isEmpty()) return 0;
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == ',' || c == ' ') {
                count++;
            }
        }
        return count;
    }

    public int countNumbers(String text) {
        if (text == null || text.isEmpty()) return 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}

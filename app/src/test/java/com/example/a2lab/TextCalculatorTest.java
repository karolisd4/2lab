package com.example.a2lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextCalculatorTest {

    private TextCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TextCalculator();
    }

    @Test
    public void countSentences_basic() {
        String text = "Hello world. Testing! Test passed?";
        assertEquals(3, calculator.countSentences(text));
    }

    @Test
    public void countSentences_emptyString() {
        assertEquals(0, calculator.countSentences(""));
    }

    @Test
    public void countSentences_null() {
        assertEquals(0, calculator.countSentences(null));
    }

    @Test
    public void countWords_basic() {
        String text = "Hello hows it going";
        assertEquals(4, calculator.countWords(text));
    }

    @Test
    public void countWords_multipleSpaces() {
        String text = "Hello   world    huge    spaces";
        assertEquals(4, calculator.countWords(text));
    }

    @Test
    public void countSymbols_basic() {
        String text = "Hello, world.";
        assertEquals(3, calculator.countSymbols(text));
    }

    @Test
    public void countSymbols_empty() {
        assertEquals(0, calculator.countSymbols(""));
    }

    @Test
    public void countNumbers_basic() {
        String text = "2 tests and 63 apps";
        assertEquals(2, calculator.countNumbers(text));
    }

    @Test
    public void countNumbers_noNumbers() {
        String text = "No number text";
        assertEquals(0, calculator.countNumbers(text));
    }
}

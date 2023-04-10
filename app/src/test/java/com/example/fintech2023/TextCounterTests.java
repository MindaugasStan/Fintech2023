package com.example.fintech2023;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.fintech2023.utils.TextCounter;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TextCounterTests {
    @Test
    public void getCharsCount_EmptyStringInput() {
        String givenValue = "";
        String expectedValue = "0";
        String actualValue = TextCounter.getCharsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCharsCount_CorrectInput() {
        String givenValue = "Characters";
        String expectedValue = "10";
        String actualValue = TextCounter.getCharsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCharsCount_NullInput() {
        String givenValue = null;
        String expectedValue = "0";
        String actualValue = TextCounter.getCharsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_EmptyStringInput() {
        String givenValue = "";
        String expectedValue = "0";
        String actualValue = TextCounter.getWordsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_CorrectInput_OneWord() {
        String givenValue = "Characters";
        String expectedValue = "1";
        String actualValue = TextCounter.getWordsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_CorrectInput_ThreeWord() {
        String givenValue = "Characters are these";
        String expectedValue = "3";
        String actualValue = TextCounter.getWordsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_NullInput() {
        String givenValue = null;
        String expectedValue = "0";
        String actualValue = TextCounter.getWordsCount(givenValue);
        assertEquals(expectedValue, actualValue);
    }
}
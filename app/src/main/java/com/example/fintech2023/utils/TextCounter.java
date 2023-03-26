package com.example.fintech2023.utils;

public class TextCounter {
    public static String getCharsCount(String inputString){
        return String.valueOf(inputString.length());
    }

    public static String getWordsCount(String inputString){
        String text = inputString.replace("\n", " ");
        String[] textArray = text.split(" ");
        return String.valueOf(textArray.length);
    }
}

package com.example.fintech2023.utils;

public class TextCounter {
    public static String getCharsCount(String inputString){
        if(inputString == null)
        {
            return "0";
        }
        return String.valueOf(inputString.length());
    }

    public static String getWordsCount(String inputString){
        if(inputString == null || inputString.isEmpty())
        {
            return "0";
        }
        String text = inputString.replace("\n", " ");
        String[] textArray = text.split(" ");
        return String.valueOf(textArray.length);
    }
}

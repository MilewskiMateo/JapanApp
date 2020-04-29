package com.example.jappanappprogram;

import java.util.Arrays;
import java.util.List;

public class RandomWordPicker {

    public static String getOneRandomHiraKataWord() {

        List<String> hiragana = Arrays.asList(
                "a", "i", "u", "e", "o",
                "ka", "ki", "ku", "ke", "ko",
                "ga", "gi", "gu", "ge", "go",
                "sa", "shi", "su", "se", "so",
                "za", "ji", "zu", "ze", "zo",
                "ta", "chi", "tsu", "te", "to",
                "da", "de", "do",
                "na", "ni", "nu", "ne", "no","ha",
                "hi", "fu", "he", "ho",
                "ba", "bi", "bu", "be", "bo",
                "pa", "pi", "pu", "pe", "po",
                "ma", "mi", "mu", "me", "mo",
                "ra", "ri", "ru", "re", "ro",
                "ya","yu","yo","wa",
                "kya","kyu","kyo",
                "gya","gyu","gyo",
                "sha","shu","sho",
                "ja","ju","jo",
                "cha","chu","cho",
                "nya","nyu","nyo",
                "hya","hyu","hyo",
                "bya","byu","byo",
                "pya","pyu","pyo",
                "mya","myu","myo",
                "rya","ryu","ryo"

        );
        int max = hiragana.size()-1;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return hiragana.get(rand);
    }

    public static String getOneRandomKanjiWord() {

        List<String> hiragana = Arrays.asList("a", "i", "u", "e", "o", "ka", "ki", "ku", "ke", "ko");
        int max = 10;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return hiragana.get(rand);
    }
}

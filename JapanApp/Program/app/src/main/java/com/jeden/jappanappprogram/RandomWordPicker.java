package com.jeden.jappanappprogram;

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
                "na", "ni", "nu", "ne", "no", "ha",
                "hi", "fu", "he", "ho",
                "ba", "bi", "bu", "be", "bo",
                "pa", "pi", "pu", "pe", "po",
                "ma", "mi", "mu", "me", "mo",
                "ra", "ri", "ru", "re", "ro",
                "ya", "yu", "yo", "wa",
                "kya", "kyu", "kyo",
                "gya", "gyu", "gyo",
                "sha", "shu", "sho",
                "ja", "ju", "jo",
                "cha", "chu", "cho",
                "nya", "nyu", "nyo",
                "hya", "hyu", "hyo",
                "bya", "byu", "byo",
                "pya", "pyu", "pyo",
                "mya", "myu", "myo",
                "rya", "ryu", "ryo"

        );
        int max = hiragana.size() - 1;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return hiragana.get(rand);
    }

    public static String getOneRandomKanjiWord() {

        List<String> kanji = Arrays.asList(
                "bamboo", "before", "below", "blue",
                "book", "car", "character", "child", "circle", "correct", "day", "dog", "ear",
                "early", "eight", "empty", "enter", "evening", "exam", "eye", "fire", "five", "flower",
                "forest", "four", "gold", "grass", "grow", "hand", "heavens", "hundred", "inside",
                "insect", "jewel", "king", "large", "left", "leg", "life", "little", "male", "month",
                "mountain", "mouth", "name", "nine", "one", "person", "power", "rain", "rest", "right",
                "see", "sentence", "seven", "shellfish", "six", "soil", "sound", "spirit", "stone",
                "stream", "study", "ten", "thousand", "thread", "three", "town", "tree", "two", "water",
                "white", "willage", "women", "year"
        );
        int max = kanji.size() - 1;
        int min = 0;
        int rand = (int) (Math.random() * max - min + 1) + min - 1;
        return kanji.get(rand);
    }
}

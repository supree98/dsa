package com.spooky.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToStringMap = new HashMap<>();
        Map<String, Character> stringToCharMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (charToStringMap.containsKey(pattern.charAt(i))) {
                if (!charToStringMap.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                charToStringMap.put(pattern.charAt(i), words[i]);
            }

            if (stringToCharMap.containsKey(words[i])) {
                if (stringToCharMap.get(words[i]) != pattern.charAt(i)) {
                    return false;
                }
            } else {
                stringToCharMap.put(words[i], pattern.charAt(i));
            }
        }

        return true;
    }

}

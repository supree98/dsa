package com.spooky.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(tMap.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("aacc", "ccac"));
    }
}

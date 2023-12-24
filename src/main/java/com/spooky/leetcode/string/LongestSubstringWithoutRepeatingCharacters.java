package com.spooky.leetcode.string;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(c);
                max = Math.max(max, r - l + 1);
                r++;
            }
        }

        return max;
    }

}

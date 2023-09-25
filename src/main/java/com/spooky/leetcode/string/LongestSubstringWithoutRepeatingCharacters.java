package com.spooky.leetcode.string;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }

        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        set.add(chars[left]);
        while (right < chars.length) {
            if (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            } else {
                set.add(chars[right]);
                max = Math.max(max, right - left + 1);
                right++;
            }
        }

        return max;
    }

}

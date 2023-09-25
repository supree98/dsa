package com.spooky.leetcode.string;

public class LongestRepeatingCharacterReplacement {

    /*
        currentLength - maxFreq <= k     // if this is the condition then we can replace k letters to get all the letters same
     */
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxFreq = 0;
        int start = 0;
        int end = 0;

        int[] count = new int[26];

        while (end < s.length()) {
            char c = s.charAt(end);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);
            int size = end - start + 1;

            if (size - maxFreq > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int res = new LongestRepeatingCharacterReplacement().characterReplacement("AABAACC", 1);
        System.out.println(res);
    }
}

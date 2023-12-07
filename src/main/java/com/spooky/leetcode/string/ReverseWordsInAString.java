package com.spooky.leetcode.string;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        // Trim leading and trailing whitespaces and split the string into words
        String[] words = s.trim().split("\\s+");

        // Reverse the order of words
        reverse(words);

        // Join the reversed words using static join method from String class into a single string with spaces
        return String.join(" ", words);
    }

    private void reverse(String[] words) {
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
    }

}

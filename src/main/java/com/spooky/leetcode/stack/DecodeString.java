package com.spooky.leetcode.stack;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> words = new Stack<>();

        String currentWord = "";
        int currentCount = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            }
            else if (c == '[') {
                counts.push(currentCount);
                words.push(currentWord);
                currentCount = 0;
                currentWord = "";
            }
            else if (c == ']') {
                int repeat = counts.pop();
                String prevWord = words.pop();
                currentWord = currentWord.repeat(repeat);
                currentWord = prevWord + currentWord;
            } else {
                currentWord += c;
            }
        }

        return currentWord;
    }

    public static void main(String[] args) {
        DecodeString decode = new DecodeString();
        System.out.println(decode.decodeString("3[a]2[bc]"));
        System.out.println(decode.decodeString("3[a2[c]]"));
        System.out.println(decode.decodeString("2[abc]3[cd]ef"));
    }

}

package com.spooky.learnbay.stack;

import java.util.Stack;

public class BalancedBracket {

    public static void main(String[] args) {
        String input = "(()))";
        boolean result = isValid(input);
        System.out.println(input + " => " + result);
    }

    public static boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<>();
        char[] chars = brackets.toCharArray();
        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

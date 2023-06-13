package com.spooky.learnbay.stack;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        InfixToPostfix o = new InfixToPostfix();
        String result = o.infixToPostfix("A+B*C+D");
        System.out.println(result);
    }

    public String infixToPostfix(String infixStr) {
        int len = infixStr.length();
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < len; i++) {
            char c = infixStr.charAt(i);
            if (Character.isLetter(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); //rid of "("
            } else {
                int priority = getPriority(c);
                if (priority == 0)
                    throw new RuntimeException("Unindentified char found");
                while (!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private int getPriority(char operator) {
        int priority = 0;
        switch (operator) {
            case '^':
                priority = 4;
                break;
            case '%':
            case '/':
            case '*':
                priority = 3;
                break;
            case '+':
            case '-':
                priority = 2;
                break;
            case '(':
                priority = 1;
                break;
        }
        return priority;
    }
}

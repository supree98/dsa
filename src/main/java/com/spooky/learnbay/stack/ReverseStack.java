package com.spooky.learnbay.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(20);
        stack.push(10);
        /*      10
                20
                30      */
        System.out.println(stack);
        System.out.println(reverseStack(stack));
    }

    public static <T> Stack<T> reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        T item = stack.pop();
        reverseStack(stack);
        addBottom(stack, item);


        return stack;
    }

    private static <T> void addBottom(Stack<T> stack, T value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        T item = stack.pop();
        addBottom(stack, value);
        stack.push(item);
    }
}

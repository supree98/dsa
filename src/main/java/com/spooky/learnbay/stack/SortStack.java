package com.spooky.learnbay.stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(40);
        stack.push(30);
        System.out.println(stack);
        System.out.println(sortStack(stack));
    }

    public static <T> Stack<T> sortStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        T item = stack.pop();
        sortStack(stack);
        insertSorted(stack, item);

        return stack;
    }

    public static <T> void insertSorted(Stack<T> stack, T value) {
        if (stack.isEmpty() || ((Integer)stack.peek()) < (Integer) value) {
            stack.push(value);
            return;
        }

        T item = stack.pop();
        insertSorted(stack, value);
        stack.push(item);
    }
}

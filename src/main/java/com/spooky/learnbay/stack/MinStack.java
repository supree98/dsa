package com.spooky.learnbay.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// assignment leetcode 155. Min Stack
public class MinStack {

    private List<Integer> items = new ArrayList<>();

    private int top = -1;

    private int min = Integer.MAX_VALUE;

    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        items.add(++top, val);
        if (val <= min) {
            min = val;
            minStack.push(min);
        }
    }

    public void pop() {
        if (top == -1) {
            return;
        }
        int val = items.get(top--);
        if (val == min) {
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }
    }

    public int top() {
        return items.get(top);
    }

    public int getMin() {
        return minStack.peek();
    }

    // test examples
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin());
        minStack.pop();
        System.out.println("top: " + minStack.top());
        System.out.println("getMin: " + minStack.getMin());
    }
}

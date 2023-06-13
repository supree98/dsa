package com.spooky.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// assignment leetcode 155. Min Stack
public class MinStack {

    private List<Integer> items;

    private int top;

    private int min;

    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        items = new ArrayList<>();
        top = -1;
        min = Integer.MAX_VALUE;
    }

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

    // test i/o
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

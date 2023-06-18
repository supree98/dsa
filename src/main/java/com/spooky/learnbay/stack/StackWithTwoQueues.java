package com.spooky.learnbay.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues<T> {

    Queue<T> queue1 = new ArrayDeque<>();

    Queue<T> queue2 = new ArrayDeque<>();

    public void push(T item) {
        queue1.add(item);
    }

    public T pop() {
        T lastItem = null;
        while (queue1.size() > 1) {
            T item = queue1.remove();
            queue2.add(item);
        }
        lastItem = queue1.remove();

        // swap q1 & q2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return lastItem;
    }

    public static void main(String[] args) {
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(5);
        stack.push(15);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

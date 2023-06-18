package com.spooky.learnbay.queue;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

    private Stack<T> stack1 = new Stack<>();

    private Stack<T> stack2 = new Stack<>();

    public void enqueue(T item) {
        stack1.push(item);
    }

    public T deque() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException("No elements in the Queue to remove");
        }
        if (stack2.isEmpty()) {
            moveItemsToStack2();
        }
        return stack2.pop();
    }

    private void moveItemsToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.deque());
    }
}

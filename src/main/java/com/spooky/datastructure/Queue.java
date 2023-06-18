package com.spooky.datastructure;

public class Queue<T> {

    private Object[] items;
    private int first;
    private int last;
    private int count;
    private int capacity;

    public Queue() {
        capacity = 5;
        items = new Object[capacity];
    }

    public void enqueue(T item) {
        items[last] = item;
        last = (last + 1) % capacity;
        count++;
    }

    public T dequeue() {
        T item =  (T) items[first];
        first = (first + 1) % capacity;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(25);
        queue.enqueue(50);

        System.out.println("isEmpty: " + queue.isEmpty());
        System.out.println(queue.dequeue());
        queue.enqueue(10);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


        System.out.println("isEmpty: " + queue.isEmpty());
    }

}

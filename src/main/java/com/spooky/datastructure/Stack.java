package com.spooky.datastructure;

import java.util.Arrays;

public class Stack<T> {

    private Object[] items;
    private int top = -1;
    private int count;

    public Stack() {
        items = new Object[10];
    }

    public void push(T item) {
        ensureCapacity();
        items[++top] = item;
        count++;
    }

    public T pop() {
        T item = (T) items[top--];
        count--;
        return item;
    }

    private void ensureCapacity() {
        if (items.length == count) {
            grow();
        }
    }

    private void grow() {
        int newSize = (int) (count * 1.5);
        Object[] newItems = new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, count);
        items = newItems;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}

package com.spooky.learnbay.linkedlist;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

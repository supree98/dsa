package com.spooky.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;

    private Node head;

    private Node tail;

    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int value = node.val;
        if (tail == node) {
            return value;
        }

        updateRecentlyUsed(node);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateRecentlyUsed(node);
            return;
        }

        Node node = new Node(key, value);
        if (map.size() >= capacity) {
            int mapKey = head.key;
            map.remove(mapKey);
            if (capacity == 1) {
                head = null;
                tail = null;
            } else {
                Node next = head.next;
                head.next = null;
                head.prev = null;
                head = next;
            }
        }
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        map.put(key, node);
    }

    private void updateRecentlyUsed(Node node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = head.next;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}

package com.spooky.leetcode.list;

public class MyHashSet {

    private boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(2));
    }
}

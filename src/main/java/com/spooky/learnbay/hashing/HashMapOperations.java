package com.spooky.learnbay.hashing;

import java.util.ArrayList;
import java.util.List;

public class HashMapOperations {

    private List[] buckets = new List[10];

    private class Node {
        String key;
        String val;

        public Node(String key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    private int getIndex(String key) {
        Hashing hashing = new Hashing();
        return hashing.hash(key, 10);
    }

    public void put(String key, String val) {
        int index = getIndex(key);
        List<Node> bucket = buckets[index];
        if (bucket == null) {
            bucket = new ArrayList<>();
        }
        Node node = new Node(key, val);
        bucket.add(node);
        buckets[index] = bucket;
    }

    public String get(String key) {
        int index = getIndex(key);
        List<Node> bucket = buckets[index];
        for (Node node : bucket) {
            if (node.key == key) {
                return node.val;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMapOperations mapOperations = new HashMapOperations();
        mapOperations.put("10", "Lionel Messi");
        mapOperations.put("7", "CR7");
        System.out.println(mapOperations.get("10"));
        System.out.println(mapOperations.get("7"));
    }
}

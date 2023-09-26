package com.spooky.leetcode.string;

public class ImplementTrie {

    static class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // Assuming lowercase English letters
            isEndOfWord = false;
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public void setEnd() {
            isEndOfWord = true;
        }

        public boolean isEnd() {
            return isEndOfWord;
        }
    }

    TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }
            current = current.get(ch);
        }
        current.setEnd();
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.containsKey(ch)) {
                return false;
            }
            current = current.get(ch);
        }
        return current != null && current.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.containsKey(ch)) {
                return false;
            }
            current = current.get(ch);
        }
        return true;
    }

}

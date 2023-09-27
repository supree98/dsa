package com.spooky.leetcode.string;

public class DesignAddAndSearchWordsDataStructure {

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

    private TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                TrieNode[] children = node.children;
                for (TrieNode child : children) {
                    if (child != null && search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if ((!node.containsKey(ch))) {
                    return false;
                }
            }
            node = node.get(ch);
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure d = new DesignAddAndSearchWordsDataStructure();
        d.addWord("bad");
        d.search("b.d");
    }

}

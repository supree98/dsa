package com.spooky.learnbay.hashing;

import com.spooky.learnbay.linkedlist.Node;

public class Hashing {

    // simple has code generator ranging from 0 to 10 for int (can be used as an index!)
    public int hash(int val) {
        return val % 10;
    }

    // simple has code generator ranging from 0 to 10 for string
    public int hash(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            int numericVal = Character.getNumericValue(c);
            sum += numericVal;
        }

        return sum % 10;
    }

    // simple has code generator ranging from 0 to 10 for any key (also using hasCode method!)
    public int hash(Object key, int range) {
        int hashCode = key.hashCode();
        return hashCode % range;
    }

    // hash code generate in HashMap java!
    // get the hashcode from object class's method and do triple right shift with 16 then XOR with the result
    public int hash(Object key) {
        int h = key == null ? 0 : key.hashCode();
        return (h ^ h >>> 16) % 10;    // % 10 is to set the range from 0 to 10
    }

    public static void main(String[] args) {
        var hashing = new Hashing();
        System.out.println(hashing.hash(10452));
        System.out.println(hashing.hash("Lionel Messi"));
        System.out.println(hashing.hash(new Node(10)));
        System.out.println(hashing.hash(new Object(), 10));
    }
}

package com.spooky.learnbay.bit;

public class BitRepresentation {

    public static String printBits(int n) {
        return printBits(n, new StringBuilder()).toString();
    }

    private static StringBuilder printBits(int n, StringBuilder binary) {
        if (n == 0) {
            return binary;
        }

        int bit = n % 2;
        binary.insert(0, bit + " ");
        return printBits(n / 2, binary);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(printBits(n));
    }
}

package com.spooky.learnbay.recursion;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
}

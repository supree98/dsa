package com.spooky.dynamicprogramming;

import java.util.Arrays;

public class FibonacciWithMemoization {

    public static long fib(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }

    private static long fib(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fib(100));
        long end = System.currentTimeMillis();
        System.out.println("TIME: " + (end - start));
    }
}

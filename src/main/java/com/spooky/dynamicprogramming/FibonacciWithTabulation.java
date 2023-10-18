package com.spooky.dynamicprogramming;

public class FibonacciWithTabulation {

    // this takes O(n) space for dp array
    public static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // this takes O(1) space complexity!!!
    public static int fibOptimized(int n) {
        int secondPrev = 0;
        int prev = 1;

        for (int i = 2; i < n; i++) {
            int current = prev + secondPrev;
            secondPrev = prev;
            prev = current;
        }
        return prev + secondPrev;
    }

    public static void main(String[] args) {
        System.out.println(fibOptimized(4));
    }
}

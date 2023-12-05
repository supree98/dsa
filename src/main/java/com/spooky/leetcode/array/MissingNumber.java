package com.spooky.leetcode.array;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;

        // formula of sum of natural numbers
        int summation = (n * (n + 1)) / 2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return summation - actualSum;
    }

}

package com.spooky.leetcode.dp;

public class HouseRobber {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            // if you choose the curr then skip prev (can not pick adj elem) and pick prev to prev OR simply pick the prev
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        int res = new HouseRobber().rob(nums);
        System.out.println(res);
    }
}

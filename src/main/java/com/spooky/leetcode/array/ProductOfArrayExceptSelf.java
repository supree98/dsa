package com.spooky.leetcode.array;

import java.util.Arrays;

// 238. Product of Array Except Self
public class ProductOfArrayExceptSelf {

    // O(n) + O(n) for the space complexity (2 new arrays)
    // as an enhancement we can keep prefix array and remove postfix (use nums array) so space complexity becomes O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int prefixIndex = i - 1;
            int postFixIndex = i + 1;
            if (prefixIndex == -1) {
                nums[i] = postfix[postFixIndex];
            } else if (postFixIndex == nums.length) {
                nums[i] = prefix[prefixIndex];
            } else {
                nums[i] = prefix[prefixIndex] * postfix[postFixIndex];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }
}

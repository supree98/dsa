package com.spooky.leetcode.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                // go to next for left and copy the num from right
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}

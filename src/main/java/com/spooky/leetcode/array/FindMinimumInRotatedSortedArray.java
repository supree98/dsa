package com.spooky.leetcode.array;

// 153. Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int min = nums[0];

        int left = 0;
        int right = nums.length - 1;

        // left = right for input like [2, 1]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid + 1]);
                right = mid;
            }
        }
        return min;
    }

}

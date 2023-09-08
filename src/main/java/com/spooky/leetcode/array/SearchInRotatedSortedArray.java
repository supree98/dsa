package com.spooky.leetcode.array;

// 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {

    /*
        look for the sorted part after mid is found and check if the target elem is in the sorted part,
        else look in the other part.
        left = right is important in while condition
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // left = right because there might be only one elem with left = right (when mid -1 is done)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

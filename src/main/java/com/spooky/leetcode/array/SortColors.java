package com.spooky.leetcode.array;

public class SortColors {

    // uses Dutch National Flag algo
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                // do not do mid++ because, from the high pointer we might have got 0
                high--;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        new SortColors().sortColors(nums);
    }

}

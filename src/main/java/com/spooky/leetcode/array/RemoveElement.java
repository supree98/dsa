package com.spooky.leetcode.array;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        // keep two pointers
        int i = 0;
        int n = nums.length - 1;

        int count = 0;

        while (i <= n) {
            if (nums[i] == val) {
                nums[i] = nums[n];
                n--;
            } else {
                i++;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums, val);
    }

}

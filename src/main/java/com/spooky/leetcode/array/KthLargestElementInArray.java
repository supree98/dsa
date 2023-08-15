package com.spooky.leetcode.array;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            int b = partitioner(nums, start, end);
            if (b == nums.length - k) {                                 // trick!!
                return nums[b];
            } else if (b < nums.length - k) {                           // means the kth the largest lies on the right partition
                start = b + 1;
            } else {                                                    // means the kth the largest lies on the left partition
                end = b - 1;
            }
        }
    }

    private int partitioner(int[] nums, int start, int end) {
        int b = start - 1;
        int pivot = nums[end];
        for (int i = start; i <= end; i++) {
            if (nums[i] <= pivot) {
                b++;
                swap(nums, b, i);
            }
        }
        return b;
    }

    private void swap(int[] nums, int fromIndex, int toIndex) {
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        KthLargestElementInArray largest = new KthLargestElementInArray();
        int val = largest.findKthLargest(nums, k);
        System.out.println(val);
    }
}

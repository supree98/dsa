package com.spooky.algorithm.sort;

import com.spooky.algorithm.MaxHeap;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        MaxHeap.heapify(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            int max = nums[0];
            nums[0] = nums[i];
            nums[i] = max;

            MaxHeap.heapify(nums, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 5};
        new HeapSort().sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}

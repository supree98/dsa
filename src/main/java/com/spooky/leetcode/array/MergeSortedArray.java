package com.spooky.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int leftIndex = m - 1;
        int rightIndex = n - 1;
        int mergedIndex = m + n - 1;

        // TRICK: nums1 always has the capacity to fill... move all the larger elem to the end of nums1
        while (leftIndex >= 0 && rightIndex >= 0) {
            if (nums1[leftIndex] > nums2[rightIndex]) {
                nums1[mergedIndex] = nums1[leftIndex];
                leftIndex--;
                mergedIndex--;
            } else {
                nums1[mergedIndex] = nums2[rightIndex];
                rightIndex--;
                mergedIndex--;
            }
        }
        while (rightIndex >= 0) {
            nums1[mergedIndex] = nums2[rightIndex];
            rightIndex--;
            mergedIndex--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

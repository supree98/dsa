package com.spooky.algorithm;

import java.util.Arrays;

public class MaxHeap {

    public static void heapify(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {      // Start from the bottom parent
            heapify(nums, n, i);
        }
    }

    // Function to heapify a subtree rooted at index 'index'
    // This assumes that the subtrees rooted at left and right are already max-heaps.
    public static void heapify(int[] nums, int n, int root) {
        int largest = root;      // Initialize the largest element as the root (assume it is the largest)
        int leftChild = 2 * root + 1;   // Left child index
        int rightChild = 2 * root + 2;  // Right child index

        // Check if the left child exists and is greater than the current largest
        if (leftChild < n && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        // Check if the right child exists and is greater than the current largest
        if (rightChild < n && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        if (largest == root) {
            return;
        }

        swap(nums, largest, root);

        // Recursively heapify the affected subtree
        heapify(nums, n, largest);
    }

    private static void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        MaxHeap.heapify(nums);

        System.out.println(Arrays.toString(nums));
    }
}

package com.spooky.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        boolean isAlreadySorted = true; // improves performance if the arr is already sorted
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[j - 1]) {
                    isAlreadySorted = false;
                    swap(arr, j, j - 1);
                }
            }
            if (isAlreadySorted) {
                return;
            }
        }
    }

    private void swap(int[] arr, int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 7, 3, 8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

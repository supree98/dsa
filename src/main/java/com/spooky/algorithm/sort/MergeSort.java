package com.spooky.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    // This is also called "Divide and Conquer"
    public void sort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        // Divide the arr to 2 sub arrays
        int midIndex = getMidIndex(arr);
        int[] leftArr = getSubArr(arr, 0, midIndex - 1);
        int[] rightArr = getSubArr(arr, midIndex, arr.length - 1);
        sort(leftArr);
        sort(rightArr);

        // Merge the 2 sub arrays in sorted manner
        merge(arr, leftArr, rightArr);
    }

    public void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftPointer = 0;
        int rightPointer = 0;
        int resIndex = 0;
        while (leftPointer < leftArr.length && rightPointer < rightArr.length) {
            if (leftArr[leftPointer] < rightArr[rightPointer]) {
                arr[resIndex++] = leftArr[leftPointer++];
            } else {
                arr[resIndex++] = rightArr[rightPointer++];
            }
        }
        while (leftPointer < leftArr.length) {
            arr[resIndex++] = leftArr[leftPointer++];
        }
        while (rightPointer < rightArr.length) {
            arr[resIndex++] = rightArr[rightPointer++];
        }
    }

    private int getMidIndex(int[] arr) {
        return arr.length / 2;
    }

    private int[] getSubArr(int[] arr, int left, int right) {
        int[] res = new int[right - left + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[left++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 7, 3, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

package com.spooky.algorithm.sort;

import java.util.Arrays;

public class MergeSortUsingMultiThreading {

    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int midIndex = arr.length / 2;
        int[] leftSubArr = getSubArr(arr, 0, midIndex - 1);
        int[] rightSubArr = getSubArr(arr, midIndex, arr.length - 1);

        Thread leftArrSorter = new Thread(() -> sort(leftSubArr));
        Thread rightArrSorter = new Thread(() -> sort(rightSubArr));

        leftArrSorter.start();
        rightArrSorter.start();

        try {
            // let the main thread wait for the left and right arrays to sort and merge them
            leftArrSorter.join();
            rightArrSorter.join();
        } catch (InterruptedException e) {
            System.out.println("Thread got Interrupted while merging the 2 sub arrays." + e);
        }

        merge(arr, leftSubArr, rightSubArr);
    }

    public void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftLength = leftArr.length;
        int rightLength = rightArr.length;
        int i = 0;        // pointer for leftArr
        int j = 0;        // pointer for rightArr
        int k = 0;        // pointer for resArr
        while (i < leftLength && j < rightLength) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftLength) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightArr[j++];
        }
    }

    private int[] getSubArr(int[] arr, int left, int right) {
        int[] res = new int[right - left + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[left++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 7, 3, 8, 4, 6, 10, 9};
        MergeSortUsingMultiThreading mergeSort = new MergeSortUsingMultiThreading();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

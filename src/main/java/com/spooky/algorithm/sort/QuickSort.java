package com.spooky.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int b = partitioner(arr, start, end);
        sort(arr, start, b - 1);
        sort(arr, b + 1, end);
    }

    private int partitioner(int[] arr, int start, int end) {
        int pivot = arr[end];
        int b = start - 1;    // b -> boundary that separates left and right parts
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                b++;
                swap(arr, b, i);
            }
        }
        return b;
    }

    private void swap(int[] arr, int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {15, 6, 3, 1, 22, 10, 13};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

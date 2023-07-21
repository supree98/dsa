package com.spooky.algorithm.sort;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] arr, int max) {
        int[] counts = new int[max + 1];   // size (max value + 1 in arr because the index represents the value)
        for (int i = 0; i < arr.length; i++) {
            int count = counts[arr[i]];
            counts[arr[i]] = count + 1;
        }

        int current = 0;
        for (int i = 1; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j ++) {
                arr[current++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 2, 1, 1};
        var sorter = new CountingSort();
        sorter.sort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}

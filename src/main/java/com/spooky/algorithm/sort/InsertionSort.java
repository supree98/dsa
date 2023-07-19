package com.spooky.algorithm.sort;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 6, 3, 1, 22, 10, 13};
        var sorter = new InsertionSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

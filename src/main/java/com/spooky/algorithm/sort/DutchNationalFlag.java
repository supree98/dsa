package com.spooky.algorithm.sort;

// Sort an array of 0s, 1s and 2s | Dutch National Flag problem
public class DutchNationalFlag {

    public static void sort012(int[] arr) {
        int len = arr.length;

        int low = arr[0];
        int mid = arr[0];
        int high = len - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int fromIndex, int toIndex) {
        int temp = arr[fromIndex];
        arr[fromIndex] = arr[toIndex];
        arr[toIndex] = temp;
    }

    private static void printArray(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr);
        printArray(arr);
    }
}

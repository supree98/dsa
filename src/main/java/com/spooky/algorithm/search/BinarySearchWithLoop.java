package com.spooky.algorithm.search;

public class BinarySearchWithLoop {

    public int search(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (val < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 10, 13, 15, 22};
        BinarySearchWithLoop search = new BinarySearchWithLoop();
        System.out.println(search.search(arr, 3));
    }
}

package com.spooky.algorithm.search;

public class BinarySearchUsingRecursion {

    public int search(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        return search(arr, val, left, right);
    }

    public int search(int[] arr, int val, int left, int right) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (val < arr[mid]) {
            right = mid - 1;
            return search(arr, val, left, right);
        } else {
            left = mid + 1;
            return search(arr, val, left, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 10, 13, 15, 22};
        var search = new BinarySearchUsingRecursion();
        System.out.println(search.search(arr, 22));
    }
}

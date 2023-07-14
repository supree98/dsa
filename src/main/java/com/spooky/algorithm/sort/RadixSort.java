package com.spooky.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public int[] sort(int[] nums) {
        int maxDigit = getMaxDigit(nums);
        if (maxDigit == 0) {
            return nums;
        }

        int decimalPlace = 1;
        for (int i = 1; i <= maxDigit; i++) {
            List<ArrayList<Integer>> bucket = getBucket();
            for (int num: nums) {
                int digit = getDigit(num, decimalPlace);
                List<Integer> bucketList = bucket.get(digit);
                bucketList.add(num);
            }
            updateTheArrayInOrderWithBucket(nums, bucket);
            decimalPlace = decimalPlace * 10;
        }

        return nums;
    }

    private void updateTheArrayInOrderWithBucket(int[] nums, List<ArrayList<Integer>> bucket) {
        int index = 0;
        for (List<Integer> bucketList : bucket) {
            for (Integer integer : bucketList) {
                nums[index++] = integer;
            }
        }
    }

    private List<ArrayList<Integer>> getBucket() {
        List<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }
        return bucket;
    }

    private int getDigit(int num, int decimalPlace) {
        while (decimalPlace != 1) {
            num = num / 10;
            decimalPlace = decimalPlace / 10;
        }
        return num % 10;
    }

    private int getMaxDigit(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num > max) {
                max = num;
            }
        }

        int count = 0;
        while (max != 0) {
            count++;
            max = max / 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 10, 3, 112, 61};
        RadixSort radixSort = new RadixSort();
        System.out.println(Arrays.toString(radixSort.sort(nums)));;
    }
}

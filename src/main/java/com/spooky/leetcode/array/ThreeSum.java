package com.spooky.leetcode.array;

import java.util.*;

// 15. 3Sum
public class ThreeSum {

    /*
    Approach for this Problem:

    Sort the input array
    Initialize a set to store the unique triplets and an output vector to store the final result
    Iterate through the array with a variable i, starting from index 0.
    Initialize two pointers, j and k, with j starting at i+1 and k starting at the end of the array.
    In the while loop, check if the sum of nums[i], nums[j], and nums[k] is equal to 0. If it is, insert the triplet into the set and increment j and decrement k to move the pointers.
    If the sum is less than 0, increment j. If the sum is greater than 0, decrement k.
    After the while loop, iterate through the set and add each triplet to the output vector.
    Return the output vector

    Time complexity:
    O(N*log(N)) for sorting
    O(N) for iteration (all pointers will visit the elem only once.
        (need to update the logic to achieve this by skipping the i, j, k if next is duplicate)
        like:
        if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
        }
        while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    set.add(list);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> numsList: set) {
            result.add(numsList);
        }
        return result;
    }
}

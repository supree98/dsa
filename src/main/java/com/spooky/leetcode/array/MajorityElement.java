package com.spooky.leetcode.array;

public class MajorityElement {

    // uses Boyer Moore algo, it uses O(n) time and O(1) space
    // we can also solve this using hashmap but that takes O(n) space
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int count = 0;
        int elem = -1;

        for (int num : nums) {
            if (count == 0) {
                // when count of the assumed elem is zero, then consider the current elem
                count++;
                elem = num;
            } else if (num == elem) {
                count++;
            } else {
                count--;
            }
        }
        return elem;
    }
}

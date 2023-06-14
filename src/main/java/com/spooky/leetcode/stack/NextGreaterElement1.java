package com.spooky.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Map<Integer, Integer> numMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // iterate nums2 from the end
        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                numMap.put(nums2[i], stack.peek());
            } else {
                numMap.put(nums2[i], -1);
            }

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = numMap.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement1 nextGreaterElement1 = new NextGreaterElement1();
        int[] result = nextGreaterElement1.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        System.out.println(Arrays.toString(result));
    }
}

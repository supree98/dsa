package com.spooky.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();

        int size = nums.length;
        int[] result = new int[size - k + 1];
        int count = 0;

        for (int i = 0; i < size; i++) {
            // peek and check if the index is in the window
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            // peek last and check if the value is less than the incoming value (consider the max incoming value)
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i >= k - 1) {
                result[count++] = nums[queue.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 2, 0, 5};
        int k = 3;
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] result = s.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}

package com.spooky.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = 0;
        for (int num : nums) {
            // check if the prev values exists, if not then this is the start of the sequence
            if (!set.contains(num - 1)) {
                int count = 0;

                // check the next/sequence exist and continue till the sequence breaks
                while (set.contains(num++)) {
                    count++;
                }
                maxStreak = Math.max(maxStreak, count);
            }
        }

        return maxStreak;
    }
}

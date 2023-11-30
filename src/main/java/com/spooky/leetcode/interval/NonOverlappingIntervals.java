package com.spooky.leetcode.interval;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return 0;
        }

        // sort the intervals
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int res = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // check the start of current and end of previous
            // (no need to save the entire previous interval, just end of prev is fine)
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } else {
                res++;
                // among prev and current interval keep the one with less end
                // (because it is more likely will not overlap with upcoming interval
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }

        return res;
    }

}

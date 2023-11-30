package com.spooky.leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        // sort before solving, because not necessarily all intervals are in sorted order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                res.add(intervals[i - 1]);
            }
        }

        // add the last remaining interval
        res.add(intervals[intervals.length - 1]);

        return res.toArray(new int[res.size()][]);
    }

}

package com.spooky.leetcode.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // add all the intervals to the result that come before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // check if any interval needs to be merged with the newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // add the newInterval
        res.add(newInterval);

        // add the remaining intervals to the result
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] res = new InsertInterval().insert(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }

}

package com.spooky.leetcode.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsII {

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int[] startTimes = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            startTimes[i] = intervals.get(i).start;
        }

        Collections.sort(intervals, (a, b) -> a.end - b.end);
        int[] endTimes = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            endTimes[i] = intervals.get(i).end;
        }

        int count = 0;
        int maxCount = 0;
        int l = 0;
        int r = 0;

        while (l < intervals.size()) {
            if (startTimes[l] < endTimes[r]) {
                // we can not use any existing room so, use a new one
                count++;
                maxCount = Math.max(maxCount, count);
                l++;
            } else {
                // there is a room which we can use
                count--;
                r++;
            }
        }

        return maxCount;
    }

    // PRIORITY QUEUE implementation
    /*
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }

            // Sort the meetings based on their start time
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            // Use a priority queue (min heap) to keep track of end times
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.offer(intervals[0][1]);

            // Iterate through the meetings
            for (int i = 1; i < intervals.length; i++) {
                // If the current meeting can be accommodated in the existing rooms, update the end time
                if (intervals[i][0] >= minHeap.peek()) {
                    minHeap.poll(); // Remove the room that finishes earliest
                }

                // Add the current meeting to the heap
                minHeap.offer(intervals[i][1]);
            }

            // The size of the heap represents the minimum number of meeting rooms required
            return minHeap.size();
        }
    */

    public static void main(String[] args) {
        Interval interval1 = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);
        List<Interval> intevals = new ArrayList();
        intevals.add(interval1);
        intevals.add(interval2);
        intevals.add(interval3);
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(intevals));
    }
}

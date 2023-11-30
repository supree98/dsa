package com.spooky.leetcode.interval;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canScheduleMeetings(int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return true;  // No meetings to schedule, so it's possible.
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        // Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i - 1][1] > meetings[i][0]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] meetings = {
                {1, 3},
                {2, 4},
                {5, 7}
        };

        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.canScheduleMeetings(meetings));
    }
}

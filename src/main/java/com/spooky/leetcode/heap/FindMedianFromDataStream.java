package com.spooky.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    // stores the left half of sorted part
    private Queue<Integer> maxHeap;
    // stores the right half of sorted part
    private Queue<Integer> minHeap;

    private boolean isEven;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
        isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            // division must be with 2.0. if it is just 2 then we will lose the decimal points
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream finder = new FindMedianFromDataStream();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}

package com.spooky.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            // if we insert null to queue, there will be null pointer exception
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            head.next = node;
            head = head.next;

            // when we get the node from the minHeap, that node might have next node
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

/*
    THIS SOLUTION WORKS BUT, THERE WILL BE CYCLE FOR FEW SCENARIOS
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            while (node != null) {
                minHeap.offer(node);
                node = node.next;
            }
        }

        ListNode head = minHeap.poll();
        ListNode tail = head;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;
        }

        return head;
    }*/

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        MergeKSortedLists merger = new MergeKSortedLists();
        ListNode result = merger.mergeKLists(new ListNode[]{list1, list2, list3});

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}

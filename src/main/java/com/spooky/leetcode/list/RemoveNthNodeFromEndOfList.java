package com.spooky.leetcode.list;

public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // use 2 pointer approach
        ListNode first = dummy;
        ListNode second = dummy;

        // advance the first node to n
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // advance both first and second till first is null,
        // now the second is pointing to the prev node from the node that we want to remove
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // delete the next node
        second.next = second.next.next;
        return dummy.next;
    }
}

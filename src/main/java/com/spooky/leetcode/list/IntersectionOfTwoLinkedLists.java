package com.spooky.leetcode.list;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sizeA = 0;
        int sizeB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            sizeA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            sizeB++;
            tempB = tempB.next;
        }
        if (sizeA > sizeB) {
            int diff = sizeA - sizeB;
            while (diff != 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = sizeB - sizeA;
            while (diff != 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

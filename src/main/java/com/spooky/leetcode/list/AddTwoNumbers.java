package com.spooky.leetcode.list;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = addTwoNumbers(l1, l2, 0);
        return dummy.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        if (l1 == null && l2 == null & carry != 0) {
            return new ListNode(carry);
        }
        int val1 = 0;
        int val2 = 0;
        ListNode l1Next = null;
        ListNode l2Next = null;
        if (l1 != null) {
            val1 = l1.val;
            l1Next = l1.next;
        }
        if (l2 != null) {
            val2 = l2.val;
            l2Next = l2.next;
        }

        int sum = val1 + val2 + carry;
        int num = sum % 10;
        carry = sum / 10;

        // create a new node and set it's next by recursively calculating the next nodes sum
        ListNode node = new ListNode(num);
        node.next = addTwoNumbers(l1Next, l2Next, carry);
        return node;
    }
}

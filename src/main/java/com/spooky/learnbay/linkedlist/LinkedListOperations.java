package com.spooky.learnbay.linkedlist;

public class LinkedListOperations {

    public Node insertAtBeginning(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public void insertAtEnd(Node head, int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void delete(Node head, int data) {
        Node temp = head;

        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public Node middleNode(Node head) {
        Node jumpOne = head;
        Node jumpTwo = head;

        while (jumpTwo != null && jumpTwo.next != null) {
            jumpOne = jumpOne.next;
            jumpTwo = jumpTwo.next.next;
        }
        return jumpOne;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = head.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        return current;
    }

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public Node merge(Node head1, Node head2) {
//        while (head2 != null) {
//            Node temp1 = head1.next;
//            Node temp2 = head2.next;
//
//            head1.next = head2;
//            head2.next = temp1;
//
//            head1 = temp1;
//            head2 = temp2;
//        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        head1.next = merge(head2, head1.next);
        return head1;
    }

    // test
    public static void main(String[] args) {
        LinkedListOperations lo = new LinkedListOperations();
//        Node head = new Node(10);
//        head = lo.insertAtBeginning(head, 20);
//        head = lo.insertAtBeginning(head, 30);
//        head = lo.insertAtBeginning(head, 40);

//        lo.insertAtEnd(head, 20);
//        lo.insertAtEnd(head, 30);
//        lo.insertAtEnd(head, 40);
//        lo.insertAtEnd(head, 50);
//        lo.insertAtEnd(head, 60);
//        lo.print(head);
//        System.out.println();
//        System.out.println(lo.middleNode(head).data);
//        head = lo.reverse(head);
//        lo.print(head);
//        System.out.println();
//        lo.delete(head, 50);
//        lo.print(head);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        lo.merge(head1, head2);
        lo.print(head1);
    }
}

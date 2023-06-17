package com.spooky.learnbay.stack;

import java.util.Stack;

/*      85	        6
        75	        4
        60	        1
        70	        2
        60	        1
        80	        1
        100	        1
        -----	    -----
        prices	    span    */
public class StockSpanner {

    Stack<Integer> prices = new Stack<>();
    Stack<Integer> spans = new Stack<>();

    public int next(int price) {
        int span = 1; // least is 1 for any price

        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            span = span + spans.pop();
        }

        prices.push(price);
        spans.push(span);

        return spans.peek();
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

}

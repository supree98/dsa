package com.spooky.leetcode.array;

public class HappyNumber {

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int num = n % 10;
                n = n / 10;
                sum += num * num;
            }
            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(3));
    }
}

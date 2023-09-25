package com.spooky.leetcode.bit;

public class SumOfTwoIntegers {

    /*
        XOR ^ does the sum, but it will not retain the carry
        so, separately get the carry and pass it left by left shift then add it in the next iteration
     */
    public int getSum(int a, int b) {
        while (b > 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(12, 5));
    }
}

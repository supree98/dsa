package com.spooky.learnbay.stack;

import java.util.Arrays;
import java.util.Stack;

// assignment leetcode 503. Next Greater Element II
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] output = new int[size];
        Arrays.fill(output, -1);

        Stack<Integer> indexesStack = new Stack<>();
        for (int i = 0; i < size * 2; i++) {
            int num = nums[i % size];

            while (!indexesStack.isEmpty() && nums[indexesStack.peek()] < num) {
                output[indexesStack.pop()] = num;
            }

            if (i < size) {
                indexesStack.push(i);
            }
        }

        return output;
    }

    // test examples
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        int[] input1 = new int[]{1, 2, 1};
        int[] input2 = new int[]{1, 2, 3, 4, 3};
        int[] output1 = nge.nextGreaterElements(input1);
        int[] output2 = nge.nextGreaterElements(input2);
        System.out.println(Arrays.toString(input1) + " -> " + Arrays.toString(output1));
        System.out.println(Arrays.toString(input2) + " -> " + Arrays.toString(output2));
    }
}

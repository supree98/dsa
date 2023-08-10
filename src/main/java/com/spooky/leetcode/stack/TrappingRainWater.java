package com.spooky.leetcode.stack;


import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    int distance = i - stack.peek() - 1;
                    int verticalHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                    trappedWater += distance * verticalHeight;
                }
            }
            stack.push(i);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappingRainWater water = new TrappingRainWater();
        int count = water.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(count);
    }
}

package com.spooky.leetcode.array;

// 11. Container With Most Water
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater most = new ContainerWithMostWater();
        System.out.println(most.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

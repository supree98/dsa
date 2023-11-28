package com.spooky.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int left = 0;
        int right = colLen - 1;
        int top = 0;
        int bottom = rowLen - 1;

        // till left <= right && top <= bottom
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                res.add(matrix[j][right]);
            }
            right--;

            for (int k = right; k >= left; k--) {
                res.add(matrix[bottom][k]);
            }
            bottom--;

            for (int l = bottom; l >= top; l--) {
                res.add(matrix[l][left]);
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}

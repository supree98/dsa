package com.spooky.leetcode.matrix;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // to track all the rows and cols to be zero
        boolean[] rowZero = new boolean[rowLen];
        boolean[] colZero = new boolean[colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == 0) {
                    rowZero[row] = true;
                    colZero[col] = true;
                }
            }
        }

        // update the entire row to zero
        for (int row = 0; row < rowLen; row++) {
            if (rowZero[row]) {
                for (int col = 0; col < colLen; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // update the entire col to zero
        for (int col = 0; col < colLen; col++) {
            if (colZero[col]) {
                for (int row = 0; row < rowLen; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}

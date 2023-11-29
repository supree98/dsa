package com.spooky.leetcode.matrix;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // transpose the matrix, col should be row + 1
        for (int row = 0; row < rowLen; row++) {
            for (int col = row + 1; col < colLen; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // reverse each row, swap should happen till colLen / 2 (basically half of the col else it will be reverted)
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][colLen - 1 - col];
                matrix[row][colLen - 1 - col] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateImage().rotate(matrix);
    }
}

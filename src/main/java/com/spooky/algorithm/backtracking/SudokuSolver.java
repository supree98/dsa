package com.spooky.algorithm.backtracking;

public class SudokuSolver {

    private boolean solveSudoku(int grid[][], int row, int col) {
        if (row == 8 && col == 9)
            return true;

        if (col == 9) {
            row++;
            col = 0;
        }

        if (grid[row][col] != 0) {
            return solveSudoku(grid, row, col + 1);
        }

        for (int i = 1; i < 10; i++) {
            if (isValid(grid, row, col, i)) {
                grid[row][col] = i;
                if (solveSudoku(grid, row, col + 1)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int grid[][], int row, int col, int val) {

        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == val) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == val) {
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    private void print(int[][] grid) {
        for (int[] row : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(row[j] + "  ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int grid[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        SudokuSolver sudokuSolver = new SudokuSolver();
        boolean res = sudokuSolver.solveSudoku(grid, 0, 0);
        if (res) {
            sudokuSolver.print(grid);
        } else {
            System.out.println("No Solution exists");
        }
    }
}

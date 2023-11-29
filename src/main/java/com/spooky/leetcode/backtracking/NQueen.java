package com.spooky.leetcode.backtracking;

public class NQueen {

    private int rowLen;

    private int colLen;

    public void solve() {
        int[][] board = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        this.rowLen = board.length;
        this.colLen = board[0].length;
        if (doesFit(board, 0)) {
            printQueensOnBoard(board);
        } else {
            System.out.println("Queens do not fit in the given board");
        }
    }

    // select a column in each recursion and check the queen fits in any of the rows in the given col
    private boolean doesFit(int[][] board, int col) {
        if (col >= colLen) {
            return true;
        }
        for (int i = 0; i < rowLen; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                boolean doesFit = doesFit(board, col + 1);
                if (!doesFit) {
                    board[i][col] = 0;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        if (col == 0) {
            return true;
        }

        for (int i = col - 1; i >= 0; i--) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; i < rowLen && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printQueensOnBoard(int[][] board) {
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solve();
    }
}

package com.spooky.leetcode.graph;

public class SurroundedRegions {

    // TRICK -> check for the ones which are not surrounded by X (all O that are in border and its neighbors
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }

        int rowLen = board.length;
        int colLen = board[0].length;

        // check all the O in the borders and updated them with temp T (looking for the regions that are not surrounded by X
        // also dfs on those elements and update the neighbor O also with temp T
        for (int row = 0; row < rowLen; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0, board);
            }
            if (board[row][colLen - 1] == 'O') {
                dfs(row, colLen - 1, board);
            }
        }

        for (int col = 0; col < colLen; col++) {
            if (board[0][col] == 'O') {
                dfs(0, col, board);
            }
            if (board[rowLen - 1][col] == 'O') {
                dfs(rowLen - 1, col, board);
            }
        }

        // now all the O are actually surrounded by X, so update them as X
        // all the T are not surrounded by X, so revert them to O
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }

    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= board.length ||
                col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'T';

        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row + 1, col, board);
        dfs(row, col - 1, board);
    }
}

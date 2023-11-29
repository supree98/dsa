package com.spooky.leetcode.matrix;

public class WordSearch {

    // use dfs and backtracking
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0) {
            return false;
        }

        int rowLen = board.length;
        int colLen = board[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rowLen][colLen];
                    if (dfs(board, word, row, col, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(0) || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        boolean result = dfs(board, word.substring(1), row, col + 1, visited) ||
                dfs(board, word.substring(1), row + 1, col, visited) ||
                dfs(board, word.substring(1), row, col - 1, visited) ||
                dfs(board, word.substring(1), row - 1, col, visited);

        visited[row][col] = false;

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        WordSearch search = new WordSearch();
        System.out.println(search.exist(board, word));
    }

}

package com.spooky.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class WordSearchIIUsingBackTrack {

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null || board.length == 0 || board[0].length == 0) {
            return List.of();
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(board, word, 0, visited, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int count, boolean[][] visited, int row, int col) {
        if (word.length() == count) {
            return true;
        }

        if (!isValidCell(board, word.charAt(count), visited, row, col)) {
            return false;
        }

        visited[row][col] = true;
        boolean isPresent =
                dfs(board, word, count + 1, visited, row - 1, col) ||
                        dfs(board, word, count + 1, visited, row, col + 1) ||
                        dfs(board, word, count + 1, visited, row + 1, col) ||
                        dfs(board, word, count + 1, visited, row, col - 1);
        visited[row][col] = false;
        return isPresent;

    }

    private boolean isValidCell(char[][] board, char c, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != c || visited[row][col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearchIIUsingBackTrack().findWords(board, words));
    }

}

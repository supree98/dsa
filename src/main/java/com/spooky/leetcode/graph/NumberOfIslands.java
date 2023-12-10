package com.spooky.leetcode.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    noOfIslands++;
                    bfs(grid, row, col);
                }
            }
        }
        return noOfIslands;
    }

    private void bfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        bfs(grid, row - 1, col);
        bfs(grid, row, col + 1);
        bfs(grid, row + 1, col);
        bfs(grid, row, col - 1);
    }

}

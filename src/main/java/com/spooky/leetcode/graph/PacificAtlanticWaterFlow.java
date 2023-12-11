package com.spooky.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rowLen = heights.length;
        int colLen = heights[0].length;

        boolean[][] pacific = new boolean[rowLen][colLen];
        boolean[][] atlantic = new boolean[rowLen][colLen];

        // dfs top & bottom row
        for (int col = 0; col < colLen; col++) {

            // pacific for top row
            dfs(0, col, heights, Integer.MIN_VALUE, pacific);

            // atlantic for bottom row
            dfs(rowLen - 1, col, heights, Integer.MIN_VALUE, atlantic);
        }

        // dfs left & right col
        for (int row = 0; row < rowLen; row++) {

            // pacific for first col
            dfs(row, 0, heights, Integer.MIN_VALUE, pacific);

            // atlantic for last col
            dfs(row, colLen - 1, heights, Integer.MIN_VALUE, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    List<Integer> coOrdinate = new ArrayList<>();
                    coOrdinate.add(row);
                    coOrdinate.add(col);
                    res.add(coOrdinate);
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, int[][] heights, int prevHeight, boolean[][] ocean) {

        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || ocean[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        ocean[row][col] = true;

        dfs(row - 1, col, heights, heights[row][col], ocean);
        dfs(row, col + 1, heights, heights[row][col], ocean);
        dfs(row + 1, col, heights, heights[row][col], ocean);
        dfs(row, col - 1, heights, heights[row][col], ocean);

    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        List<List<Integer>> res = new PacificAtlanticWaterFlow().pacificAtlantic(heights);
        System.out.println(res);
    }

}

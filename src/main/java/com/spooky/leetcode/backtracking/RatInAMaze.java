package com.spooky.leetcode.backtracking;

public class RatInAMaze {

    public boolean solve(int[][] maze, int row, int col) {

        // Reached destination
        if (row == maze.length - 1 && col == maze[0].length - 1 && maze[row][col] == 1) {
            return true;
        }

        if (row == maze.length || col == maze[0].length || maze[row][col] == 0) {
            return false;
        }

        if (solve(maze, row, col + 1)) {
            return true;
        }
        if (solve(maze, row + 1, col)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 0, 1}
        };
        RatInAMaze ratInAMaze = new RatInAMaze();
        boolean res = ratInAMaze.solve(maze, 0, 0);
        if (res) {
            System.out.println("Rat can reach the destination :)");
        } else {
            System.out.println("Rat can not reach the destination :(");
        }
    }
}

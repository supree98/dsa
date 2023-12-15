package com.spooky.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, stack)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        int count = 0;
        while (!stack.isEmpty()) {
            order[count++] = stack.pop();
        }

        return order;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited, Stack<Integer> stack) {
        // found cycle
        if (visited[course] == 1) {
            return false;
        }

        // completely visited
        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;
        for (Integer neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited, stack)) {
                return false;
            }
        }

        // mark as completely visited & add it to the order
        visited[course] = 2;
        stack.add(course);
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        new CourseScheduleII().findOrder(numCourses, prerequisites);
    }
}

package com.spooky.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    // Topological Sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // eg: prerequisite [1, 0] means 1 -> 0  (for 0 to complete 1 should be completed)

        List<List<Integer>> graph = new ArrayList<>();

        // prepare graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];

        // dfs on each node and check if there is any cycle
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int course, int[] visited) {
        // cycle detected, return immediately
        if (visited[course] == 1) {
            return false;
        }

        // node is completely visited
        if (visited[course] == 2) {
            return true;
        }

        visited[course] = 1;
        for (int neighbor : graph.get(course)) {
            if (!dfs(graph, neighbor, visited)) {
                return false;
            }
        }

        visited[course] = 2;
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        CourseSchedule schedule = new CourseSchedule();
        System.out.println(schedule.canFinish(numCourses, prerequisites));
    }
}

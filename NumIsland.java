package com.company;

import java.util.*;

/**
 * Created by Administrator on 2016/5/5 0005.
 */
public class NumIsland {

    // dfs 算法
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int numberIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(grid, marked, i, j))
                        numberIsland++;
                }
            }
        }
        return numberIsland;
    }

    private boolean dfs(char[][] grid, boolean[][] marked, int i, int j) {
        if (i >= marked.length || j >= marked[0].length || marked[i][j])
            return false;
        marked[i][j] = true;
        if (i - 1 >= 0 && !marked[i - 1][j] && grid[i - 1][j] == 1)
            dfs(grid, marked, i - 1, j);

        if (j - 1 >= 0 && !marked[i][j - 1] && grid[i][j - 1] == 1)
            dfs(grid, marked, i, j - 1);

        if (i + 1 < grid.length && !marked[i + 1][j] && grid[i + 1][j] == 1)
            dfs(grid, marked, i + 1, j);

        if (j + 1 < grid[0].length && !marked[i][j + 1] && grid[i][j + 1] == 1)
            dfs(grid, marked, i, j + 1);
        return true;
    }
}

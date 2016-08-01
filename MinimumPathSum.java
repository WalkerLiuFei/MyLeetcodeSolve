package com.company;

/**
 * Created by Administrator on 2016/7/30 0030.
 * //beat  51.74%!!..
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null ||
                (grid.length < 1 && grid[0].length < 1) )
            return 0;
        int row = grid.length;
        int line = grid[0].length;
        int[][] minPaths = new int[grid.length][grid[0].length];
        minPaths[row - 1][line - 1] = grid[row - 1][line - 1];
        for (int i = row - 2 ;i >= 0;i -- ){
            minPaths[i][line - 1 ] += minPaths[i+1][line - 1 ] + grid[i][line - 1];
        }
        for (int i = line - 2; i >= 0; i--){
            minPaths[row - 1][i] = minPaths [row - 1][i+1] + grid[row - 1][i];
        }
        for (int i = row - 2;i >= 0;i--){
            for (int j = line - 2; j >= 0; j --){
                minPaths[i][j] = Math.min(minPaths[i+1][j],minPaths[i][j+1]) + grid[i][j];
            }
        }
        return minPaths[0][0];
    }
}

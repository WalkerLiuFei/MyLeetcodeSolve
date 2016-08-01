package com.company;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/30 0030.
 * beat %5.22 ....囧。。。。
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[m-1][n-1] = 0;
        Arrays.fill(paths[m-1],1);
        for (int i = m-2 ; i >= 0; i--){
            paths[i][n-1] = 1;
            for (int j = n-2; j >= 0; j--){
                paths[i][j] = paths[i+1][j] + paths[i][j+1];
            }
        }
        return paths[0][0];
    }
}

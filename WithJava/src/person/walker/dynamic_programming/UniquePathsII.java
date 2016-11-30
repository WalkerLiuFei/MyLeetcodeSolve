package person.walker.dynamic_programming;

/**
 * beat 14 % ......
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        //首先初始化第一个元素和 第一行，第一列元素。。。因为他们都比较特殊
        paths[m-1][n-1] = 1-obstacleGrid[m-1][n-1];
        for (int i = n-2; i >=0;i--)
            paths[m-1][i] = obstacleGrid[m-1][i] == 0 ? paths[m-1][i+1] : 0;
        for (int j = m-2; j >=0;j--)
            paths[j][n-1] = obstacleGrid[j][n-1] == 0 ? paths[j+1][n-1] : 0;
        //动态规划
        for (int i = m-2; i >= 0; i--){
            //paths[i][n-1] = 1;
            for (int j = n-2; j >= 0; j--)
                paths[i][j] =  obstacleGrid[i][j] == 0 ?
                        paths[i+1][j] + paths[i][j+1] : 0;
        }
        return paths[0][0];
    }


    public int otherSoultion1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        //首先初始化第一个元素和 第一行，第一列元素。。。因为他们都比较特殊
        paths[m-1][n-1] = obstacleGrid[m-1][n-1]^1;
        for (int i = n-2; i >=0;i--)
            paths[m-1][i] = obstacleGrid[m-1][i] == 0 ? paths[m-1][i+1] : 0;
        for (int j = m-2; j >=0;j--)
            paths[j][n-1] = obstacleGrid[j][n-1] == 0 ? paths[j+1][n-1] : 0;
        //动态规划
        for (int i = m-2; i >= 0; i--){
            //paths[i][n-1] = 1;
            for (int j = n-2; j >= 0; j--)
                paths[i][j] =  obstacleGrid[i][j] == 0 ?
                        paths[i+1][j] + paths[i][j+1] : 0;
        }
        return paths[0][0];
    }
    public static void main(String[] args){
        System.out.println(new UniquePathsII().otherSoultion1(new int[][]{{0,1}}));
    }
}

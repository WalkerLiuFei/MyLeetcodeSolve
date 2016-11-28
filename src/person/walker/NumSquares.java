package person.walker;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 1;index <= n;index++){
            for (int i = 1; i * i <= index ;i++){
                dp[index] = Math.min(dp[index],Math.min(dp[index - 1] + 1,1 + dp[index - i*i]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.println(new NumSquares().numSquares(13));
    }
}

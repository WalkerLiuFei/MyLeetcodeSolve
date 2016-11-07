package person.walker;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class NumSquares {
    public int numSquares(int n) {
        if (n < 1)
            return 0;
        int[] cache = new int[n+1];
        Arrays.fill(cache,Integer.MAX_VALUE);
        cache[0] = 0;
        //三个数可开平方数的只要等于n就是最短的,特殊情况
        for (int i = 1 ; i <= n ;i++){
            for (int j = 1; j * j <= i;j++)
                cache[i] = Math.min(cache[i],cache[i - j*j] + 1);
        }
        return cache[n-1];
    }

}

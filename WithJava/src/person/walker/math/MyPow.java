package person.walker.math;

import org.junit.Test;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class MyPow {
    public double myPow(double x, int n) {
        double result = 1;
        double temp = x;
        int powerNum = Math.abs(n);
        boolean isMinInteger = false;
        if (n == Integer.MIN_VALUE){
            powerNum = Integer.MAX_VALUE;
            isMinInteger = true;
        }
        boolean symbolFlag = n > 0;
        if (x - 1.0 < 0.0001 && x - 1.0 > 0.00001)
            return x;
        do{
            if (powerNum % 2 == 1){
                result *= temp;
            }
            powerNum >>= 1;
            temp *= temp;
        }while (powerNum != 0);
        if (isMinInteger){
            return Math.abs(result);
        }
        return symbolFlag ? result : 1/result;
    }
    @Test
    public void test(){
        System.out.println(new MyPow().myPow(2.0,Integer.MIN_VALUE+2));
    }
}

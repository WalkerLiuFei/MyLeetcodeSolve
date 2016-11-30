package person.walker;

/**
 * Created by Administrator on 2016/11/22 0022.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor<= 0 && (dividend == Integer.MIN_VALUE || dividend == -1))
            return Integer.MIN_VALUE;
        int leftMove = 0;
        dividend = dividend-divisor;
        while (true){
            if (divisor<<leftMove++ > dividend)
                break;
        }
        return leftMove+1;
    }
}

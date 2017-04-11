package person.walker.math;

import org.junit.Test;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class MySqrt {
    public int mySqrt(int target) {
        if(target <= 0)
            return target;
        if (target <= 2)
            return 1;
        int front = 1;
        int end = target;
        while (front < end){
            int mid = front + (end - front) /2;
            int result = target / mid;
            int diff  = result - mid;  //mid * mid 有可能会内存溢出不能简单的这样处理
            if (diff == 0L)
                return mid;
            else if (diff < 0L)
                end = mid;
            else {
                if (mid+1 > target/ (mid+1))   //这一步最关键，是自己没有想到的，需要做的是 舍掉小数位，而不是做四舍五入的操作
                    return mid;
                front = mid + 1;
            }
        }
        return front;
    }

    @Test
    public void test(){
        System.out.println(new MySqrt().mySqrt(10));
    }
}

package person.walker.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/12/1 0001.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int farestLen = nums[0];
        for (int index = 0; index < nums.length; index++) {
            if (index <=farestLen && index + nums[index] > farestLen ) //如果可以走到当前的 index，并且当前指定的index还要比保存的 能走到的最远距离更加远。更新
                farestLen = nums[index] + index;
        }
        return farestLen > nums[nums.length - 1] + nums.length -1;
    }

/*
    private boolean solution(int[] nums) {

        for (int index = nums.length - 2; index >= 0; index--) {
            if (nums[index] + index >= nums.length - 1) { //找到了一个候选解
                if (index == 0 || solution(Arrays.copyOfRange(nums, 0, index))) //只要找到满足要求的候选解,就返回其值
                    return true;
            }
        }
        return false;
    }
*/

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
        System.out.println(new JumpGame().canJump(new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
        System.out.println(System.currentTimeMillis());

    }
}

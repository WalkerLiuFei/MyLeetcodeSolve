package person.walker;

import java.util.Arrays;
import java.util.List;

/**
 * beat 55.7 %
 */
public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return -1;
        Arrays.parallelSort(nums);
        int  result =  nums[0] + nums[1] + nums[nums.length -1];
        int  closestResult = Math.abs(result - target);

        for (int stableIndex = 0;stableIndex < nums.length-1;stableIndex++){
            int frontPointer = stableIndex +1;
            int backPointer = nums.length-1;
            while (backPointer > frontPointer){
                int temp = nums[backPointer] + nums[frontPointer] + nums[stableIndex];
                int tempClose = Math.abs(target - temp);
                if (temp > target){ //太大
                    backPointer--;
                }else                      //太小
                    frontPointer++;
                if (closestResult > tempClose){
                    closestResult = tempClose;
                    result = temp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        new _3SumClosest().threeSumClosest(new int[]{0,2,1,-3},1);
    }
}

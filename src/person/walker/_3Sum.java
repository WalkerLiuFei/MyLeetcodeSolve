package person.walker;

import java.util.*;

/**
 * Created by Administrator on 2016/11/20 0020.
 */
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.parallelSort(nums);
        for (int stableIndex = 0;stableIndex < nums.length-1;stableIndex++){
            if (nums[stableIndex] == nums[stableIndex-1])
                continue;
            int frontPointer = stableIndex +1;
            int backPointer = nums.length-1;
            while (backPointer > frontPointer){
                if (nums[backPointer-1] == nums[backPointer]){
                    backPointer--;
                    continue;
                }
                if(nums[frontPointer+1] == nums[frontPointer]){
                    frontPointer++;
                    continue;
                }
                int temp = nums[backPointer] + nums[frontPointer] + nums[stableIndex];
                if (temp == 0){
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(nums[frontPointer]);
                    list1.add(nums[backPointer]);
                    list1.add(nums[stableIndex]);
                    result.add(list1);
                    frontPointer++;
                    backPointer--;
                    continue;
                }
                if ( temp < 0){
                    frontPointer++;
                }else
                    backPointer--;
            }
        }
        return result;
    }
    public static void main(String[] args){
        List list = new _3Sum().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}

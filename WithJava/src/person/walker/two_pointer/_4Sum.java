package person.walker.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        for (int stable1 = 0;stable1 < nums.length;stable1++){
            if (stable1 > 0 && nums[stable1] == nums[stable1-1])
                continue;
            for (int stable2 = stable1+1; stable2 < nums.length;stable2++){
               if (stable2 > stable1+1 && nums[stable2] == nums[stable2-1])
                    continue;
                int hash = stable1*31;
                hash = hash * 31 + stable2;
                int frontIndex = stable2+1;
                int backIndex = nums.length -1;
                while (backIndex > frontIndex){
                    if (backIndex < nums.length -1 && nums[backIndex] == nums[backIndex+1]){
                        backIndex --;
                        continue;
                    }

                    if (frontIndex > stable2+1 && nums[frontIndex] == nums[frontIndex-1]){
                        frontIndex--;
                        continue;
                    }

                    int temp = nums[stable1] + nums[stable2] + nums[frontIndex] + nums[backIndex];
                    if (temp < target){
                        frontIndex ++;
                    }else if(temp > target){
                        backIndex --;
                    }else {
                        List list = new ArrayList();
                        list.add(nums[stable1]);
                        list.add(nums[stable2]);
                        list.add(nums[frontIndex]);
                        list.add(nums[backIndex]);
                        result.add(list);
                        frontIndex ++;
                        backIndex --;
                    }
                }
            }
        }
        return result;
    }
}

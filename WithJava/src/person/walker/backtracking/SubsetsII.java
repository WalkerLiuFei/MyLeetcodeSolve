package person.walker.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,0,result,marked);
        return result;
    }
    private void dfs(int[] nums, List<Integer> list, int currentIndex, List<List<Integer>> result, boolean[] marked) {
        result.add(new ArrayList<>(list));
        for (int index = currentIndex;index < nums.length; index ++){
            if (index > 0 && !marked[index-1] &&  nums[index] == nums[index-1] )
                continue;
            list.add(nums[index]);
            marked[index] = true;
            dfs(nums,list,index+1,result,marked);
            list.remove(list.size()-1);
            marked[index] = false;
        }
    }
}

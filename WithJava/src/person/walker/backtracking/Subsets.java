package person.walker.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums,list,0,result,marked);
        return result;
    }

    private void dfs(int[] nums, List<Integer> list, int currentIndex, List<List<Integer>> result, boolean[] marked) {
        result.add(new ArrayList<>(list));
        for (int index = currentIndex;index < nums.length; index ++){
            list.add(nums[index]);
            dfs(nums,list,index+1,result,marked);
            list.remove(list.size()-1);
        }
    }
}

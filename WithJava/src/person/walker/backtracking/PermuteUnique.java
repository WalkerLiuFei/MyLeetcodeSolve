package person.walker.backtracking;

import java.util.*;

/**
 * Created by Administrator on 2016/11/27 0027.
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] markedIndex = new boolean[nums.length];
        dfs(nums,result,list,nums.length,markedIndex);
        return result;
    }

    private void dfs(int[] nums, ArrayList<List<Integer>> result, List<Integer> list, int targetLength, boolean[] markedIndex) {
        if (list.size() == targetLength){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int index = 0; index < nums.length; index++){
             // pay attention to the !markedIndex[index-1] !!
            if (index > 0 && !markedIndex[index-1] && nums[index] == nums[index -1] || markedIndex[index] )
                continue;
            list.add(nums[index]);
            markedIndex[index] = true;
            dfs(nums,result,list,targetLength, markedIndex);
            list.remove(list.size()-1);
            markedIndex[index] = false;
        }
    }
    public static void main(String args[]){
        new PermuteUnique().permuteUnique(new int[]{1,1,3});
    }
}

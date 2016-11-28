package person.walker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/27 0027.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] marked = new boolean[nums.length];
        dfs(nums,result,list,nums.length,marked);
        return result;
    }

    private void dfs(int[] nums, ArrayList<List<Integer>> result, List<Integer> list, int targetLength, boolean[] marked) {
        if (list.size() == targetLength){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int index = 0; index < nums.length; index++){
            if (marked[index])
                continue;
            list.add(nums[index]);
            marked[index] = true;
            dfs(nums,result,list,targetLength,marked);
            list.remove(list.size()-1);
            marked[list.size()-1] = false;
        }
    }
    public static void main(String args[]){
        new Permutations().permute(new int[]{1,2,3});
    }
}

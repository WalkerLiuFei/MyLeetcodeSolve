package person.walker;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用DFS 算法，每次走完一个节点将这个节点置true
 */


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length < 1)
            return null;
        List<List<Integer>> result = new ArrayList<>();

        for (int index = 0; index < candidates.length; index++){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[index]);
            recursive(result, list, candidates, target,index,candidates[index]);
        }

        return result;
    }

    private void recursive(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int restrict,int currentValue) {
      if (currentValue == target){
            result.add(list);
            return;
        }

        for(int index2 = restrict;index2 < candidates.length;index2++){
            int value = currentValue + candidates[index2];
            list.add(candidates[index2]); // add the element
            if (value <= target){
                ArrayList newList = new ArrayList();
                newList.addAll(list);
                recursive(result, newList, candidates, target,index2,value);
            }
            list.remove(list.size() - 1); // remove the top element
        }
    }
    public static void main(String[] args){
       new CombinationSum2().combinationSum2(new int[]{2,3,4,5,6,7,8,3,8},8);
    }
}
